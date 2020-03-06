package javaPrograms.JGitAPIExamples;

import java.io.File;
import java.io.PrintWriter;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand.ListMode;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.TextProgressMonitor;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.JschConfigSessionFactory;
import org.eclipse.jgit.transport.OpenSshConfig;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.SshSessionFactory;
import org.eclipse.jgit.transport.SshTransport;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class CommitUsingJGit {

	public static void main(String[] args) {

		try {
			Repository existingRepo = new FileRepositoryBuilder()
					.setGitDir(new File("C:/Users/deepa/workspace/JavaAndSeleniumConcepts/.git")).build();

			SshSessionFactory sshSessionFactory = new JschConfigSessionFactory() {
				@Override
				protected void configure(OpenSshConfig.Host host, Session session) {
					session.setUserInfo(new UserInfo() {
						@Override
						public String getPassphrase() {
							return "passphrase";
						}

						@Override
						public String getPassword() {
							return null;
						}

						@Override
						public boolean promptPassword(String message) {
							return false;
						}

						@Override
						public boolean promptPassphrase(String message) {
							return true;
						}

						@Override
						public boolean promptYesNo(String message) {
							return true;
						}

						@Override
						public void showMessage(String message) {
						}
					});
				}
			};

			// Monitor to get git command progress printed on java System.out console
			TextProgressMonitor consoleProgressMonitor = new TextProgressMonitor(new PrintWriter(System.out));

			Git git = new Git(existingRepo);
			System.out.println("\n>>> Listing all branches\n");
			git.branchList().setListMode(ListMode.ALL).call().stream().forEach(r -> System.out.println(r.getName()));

			// Checkout to specific branch
			// git.checkout().setName("master").setForced(true).call();

			System.out.print("\n>>> Printing status of local repository\n");
			Status status = git.status().setProgressMonitor(consoleProgressMonitor).call();

			System.out.print("\n>>> Modified file\n");
			status.getModified().stream().filter(str -> str.endsWith(".java")).forEach(System.out::println);

			System.out.print("\n>>> Untracked/Newly Created file\n");
			status.getUntracked().stream().filter(str -> str.endsWith(".java")).forEach(System.out::println);

			System.out.print("\n>>> Uncommitted file\n");
			status.getUncommittedChanges().stream().filter(str -> str.endsWith(".java")).forEach(System.out::println);

			System.out.print("\n>>> Deleted/Removed file\n");
			status.getRemoved().stream().filter(str -> str.endsWith(".java")).forEach(System.out::println);

			System.out.print("\n>>> Added file\n");
			status.getAdded().stream().filter(str -> str.endsWith(".java")).forEach(System.out::println);

			System.out.println("\n>>> Committing changes\n");
			RevCommit revCommit = git.commit().setOnly("pom.xml").setMessage("Adding commit from JGIT").call();

			// RevCommit revCommit = git.commit().setAll(true).setMessage("Adding commit
			// from JGIT").call();
			System.out.println("Commited Message = " + revCommit.getFullMessage());

			// Providing credentials to push code to remote repository
			CredentialsProvider cp = new //
			UsernamePasswordCredentialsProvider("username", "password");

			// Below code to push through ssh

			Iterable<PushResult> pushLog = git.push().setTransportConfigCallback(transport -> {
				SshTransport sshTransport = (SshTransport) transport;
				sshTransport.setSshSessionFactory(sshSessionFactory);
			}).setPushAll().call();

			// Below code to push for https url.
			/*
			 * Iterable<PushResult> pushLog =
			 * git.push().setCredentialsProvider(cp).setPushAll().call();
			 */ pushLog.forEach(r -> System.out.println(r.getMessages()));

			// Close Git
			git.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // End of main method
} // End of class CommitUsngJGit