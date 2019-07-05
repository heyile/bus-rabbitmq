package com.example.configserver.JGit;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.transport.FetchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.config.server.environment.MultipleJGitEnvironmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalGitRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalGitRepository.class);

    private MultipleJGitEnvironmentRepository repository;

    public LocalGitRepository(MultipleJGitEnvironmentRepository repository) {
        this.repository = repository;
    }

    public String forceRefresh() {
        Git git = null;
        String label = "master";
        try {
            git = repository.createGitClient();
            FetchResult fetchStatus = repository.fetch(git, label);
            if (repository.isDeleteUntrackedBranches() && fetchStatus != null) {
                repository.deleteUntrackedLocalBranches(fetchStatus.getTrackingRefUpdates(), git);
            }
            // checkout after fetch so we can get any new branches, tags, ect.
            repository.checkout(git, label);
            repository.tryMerge(git, label);
            // always return what is currently HEAD as the version
            return git.getRepository().findRef("HEAD").getObjectId().getName();
        } catch (Exception e) {
            throw new IllegalStateException("Cannot load environment", e);
        } finally {
            try {
                if (git != null) {
                    git.close();
                }
            } catch (Exception e) {
                LOGGER.warn("Could not close git repository", e);
            }
        }
    }

    /**
     * 查询所有 git branch -a -r --abbrev=100 -v
     * origin/1.0.0.M2            0e119c87404360273255cd17ba0d3f3f729973d9 Update to M2 dependencies
     * origin/1.0.0.M3            bca70d52994859d49b85f2b5478f941421efefb3 Switch to 1.0.0.M3 version
     * origin/1.0.0.M4            c1387ddd8ac2c67d9f49090f92692eeb44e22f68 Update to M4
     * origin/1.0.0.RC1           e2df22bf04e84370dcb1c6b0a5c679fe41675981 Update docs with RC1 labels
     * origin/1.0.0.RELEASE       2284dec59c6a153481dbbc1c504b666e784e2b3e Add bintray properties
     *
     * @return map
     */
    public Map<String, String> branchList() {
        Map<String, String> result = new HashMap<>();
        Git git = null;
        try {
            git = repository.createGitClient();
            List<Ref> call = git.branchList().setListMode(ListBranchCommand.ListMode.REMOTE).call();
            if (call != null) {
                call.forEach(ref -> {
                    result.put(ref.getName(), ref.getObjectId().getName());
                });
            }
            return result;
        } catch (Exception e) {
            throw new IllegalStateException("Cannot load environment", e);
        } finally {
            try {
                if (git != null) {
                    git.close();
                }
            } catch (Exception e) {
                LOGGER.warn("Could not close git repository", e);
            }
        }
    }

}
