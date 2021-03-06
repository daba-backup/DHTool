package com.github.dabasan.tool;

/**
 * Methods to handle filenames.
 * @author Daba
 *
 */
public class FilenameFunctions {
	/**
	 * Replaces '\' with '/'.
	 * @param filename Original filename
	 * @return Replaced filename
	 */
	public static String ReplaceWindowsDelimiterWithLinuxDelimiter(String filename) {
		String ret=filename;
		ret=ret.replace('\\', '/');
		
		return ret;
	}
	/**
	 * Returns the directory of a file.
	 * @param filename Filename
	 * @return Directory
	 */
	public static String GetFileDirectory(String filename) {
		int last_slash_pos=filename.lastIndexOf('/');
		if(last_slash_pos==-1)return filename;
		
		String directory=filename.substring(0, last_slash_pos);
		return directory;
	}
	/**
	 * Returns the file extension.
	 * @param filename Filename
	 * @return Extension
	 */
	public static String GetFileExtension(String filename) {
		int last_dot_pos=filename.lastIndexOf('.');
		if(last_dot_pos==-1)return filename;
		
		String extension=filename.substring(last_dot_pos+1);
		return extension;
	}
	/**
	 * Returns the filename without extension.
	 * @param filename Filename
	 * @return Filename without extension
	 */
	public static String GetFilenameWithoutExtension(String filename) {
		int last_dot_pos=filename.lastIndexOf('.');
		if(last_dot_pos==-1)return filename;
		
		String ret=filename.substring(0, last_dot_pos);
		
		return ret;
	}
	/**
	 * Returns the filename without directory name.
	 * @param filename Filename
	 * @return Filename without directory name
	 */
	public static String GetFilenameWithoutDirectory(String filename) {
		int last_slash_pos=filename.lastIndexOf('/');
		if(last_slash_pos==-1)return filename;
		
		String ret=filename.substring(last_slash_pos+1);
		
		return ret;
	}
}
