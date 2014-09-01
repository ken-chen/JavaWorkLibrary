package work.ken.tools.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileTools {
	private final static Log logger = LogFactory.getLog(FileTools.class);

	/**
	 * DOES NOT MOVE does a copy.
	 * 
	 * @param dir
	 * @param toDir
	 * @param deletePrior
	 * @return
	 * @throws IOException
	 */
	public static boolean move(File dir, File toDir, boolean deletePrior)
			throws IOException {
		if (logger.isTraceEnabled())
			logger.trace("move() START");

		// DELETE DESTINATION
		if (toDir.exists() && deletePrior) {
			logger.debug("move() - deleting the existing file first");

			if (!delete(toDir)) {
				logger.warn("move() - Failed to delete destination files file prior to moving from :"
						+ toDir.getAbsolutePath());
				return false;
			}
		}
		/*
		 * JJR: removed as the move did not work when copying from local file
		 * system to nfs file system. if (!dir.renameTo(toDir)) {
		 * logger.warn("Failed to move file: " + dir.getAbsolutePath()); return
		 * false; } else { logger.warn("Moved file " + dir.getAbsolutePath() +
		 * " to " + toDir.getAbsolutePath()); return true; }
		 */

		// COPY FROM SOURCE
		if (logger.isTraceEnabled())
			logger.trace("move() - about to copy files.");

		if (!copy(dir, toDir)) {
			logger.warn("Failed to move " + dir.getAbsolutePath() + " to: "
					+ toDir.getAbsolutePath());
			return false;
		}

		// DELETE SOURCE
		/*
		 * if (logger.isTraceEnabled())
		 * logger.trace("move() - about to delete source files."); if
		 * (!delete(dir)) {
		 * logger.warn("Failed to delete the source after copying from: " +
		 * dir.getAbsolutePath() + " to: " + toDir.getAbsolutePath()); return
		 * false; }
		 */

		return true;

	}

	/**
	 * 
	 * @param file
	 * @param toFile
	 * @return
	 * @throws IOException
	 */
	public static boolean copy(File file, File toFile) throws IOException {
		if (logger.isTraceEnabled())
			logger.trace("FileTools.copy() START");

		if (file.isDirectory()) {

			// for directories, copy all files in the directory to the new one
			toFile.mkdirs();
			toFile.mkdir();

			for (File f : file.listFiles()) {
				if (!copy(f, new File(toFile, f.getName()))) {
					logger.warn("Failed to copy " + file.getAbsolutePath()
							+ " file to: " + toFile.getAbsolutePath());
					return false;
				}
			}
			return true;
		} else {

			// for files, simply open a new stream and copy data
			if (!toFile.exists()) {
				if (!toFile.createNewFile()) {
					logger.warn("Failed to create new file: "
							+ toFile.getAbsolutePath());
					return false;
				}
			}

			if (logger.isDebugEnabled())
				logger.debug("copy() - Copying the file using streams.");
			InputStream in = new FileInputStream(file);
			if (logger.isTraceEnabled())
				logger.trace("copy() - instream created.");
			try {
				OutputStream out = new FileOutputStream(toFile);
				if (logger.isTraceEnabled())
					logger.trace("copy() - outstream created.");
				try {
					byte[] buf = new byte[1024];
					int bytesRead = 0;
					while ((bytesRead = in.read(buf)) >= 0) {
						out.write(buf, 0, bytesRead);
					}
				} finally {
					if (logger.isTraceEnabled())
						logger.trace("copy() - closing outstream.");
					out.close();
				}
			} finally {
				if (logger.isTraceEnabled())
					logger.trace("copy() - closing instream.");
				in.close();
			}

			logger.info("Copied file " + file.getAbsolutePath() + " to "
					+ toFile.getAbsolutePath());
			return true;
		}
	}

	/**
	 * Recursive delete function. Deletes all files and directories.
	 * 
	 * @param dir
	 * @return
	 */
	public static boolean delete(File dir) {
		if (dir.isDirectory()) {
			for (File f : dir.listFiles()) {
				if (!delete(f)) {
					return false;
				}
			}
		}
		if (dir.exists() && dir.canWrite()
				&& !dir.getName().toLowerCase().contains(".nfs")) {
			if (!dir.delete()) {
				if (dir.isDirectory()) {
					//ignore the failure of deleting the site specific folder because of .nfs lock files
					return true;
				} else {
					logger.warn("Failed to delete file: "
							+ dir.getAbsolutePath());
					return false;
				}
			} else {
				logger.info("Deleted file: " + dir.getAbsolutePath());
				return true;
			}
		}
		return true;
	}
}
