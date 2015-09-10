package com.bhn.lc.localfiles;

import java.util.Comparator;

import com.bhn.lc.filespublic.FileInfo;


/** 排序 **/
public class FileComparator implements Comparator<FileInfo> {

	public int compare(FileInfo file1, FileInfo file2) {
		//文件夹排在前面
		if (file1.IsDirectory && !file2.IsDirectory) {
			return -1000;
		} else if (!file1.IsDirectory && file2.IsDirectory) {
			return 1000;
		}
		// 相同类型按名称排序
		return file1.Name.compareTo(file2.Name);
	}
}