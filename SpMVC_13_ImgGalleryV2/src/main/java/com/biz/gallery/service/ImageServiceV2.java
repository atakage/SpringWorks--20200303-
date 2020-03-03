package com.biz.gallery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.domain.ImageVO;
import com.biz.gallery.repository.ImageDao;
import com.biz.gallery.repository.ImageFileDao;

@Service("imgServiceV2")
public class ImageServiceV2 extends ImageService{

	@Autowired
	public ImageServiceV2(ImageDao imDao, FileService fService, ImageFileService ifService, ImageFileDao ifDao) {
		super(imDao, fService, ifService, ifDao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int update(ImageVO imageVO) {
		// TODO Auto-generated method stub
		
		List<String> fileNames = imageVO.getImg_file_upload_name();
		
		if(fileNames != null && fileNames.size() > 0) {
			
			imageVO.setImg_file(fileNames.get(0));
			
			List<ImageFilesVO> files = new ArrayList<ImageFilesVO>();
			
			for(String fileName : fileNames) {
				files.add(ImageFilesVO.builder().img_file_origin_name(fileName.substring(36)).img_file_upload_name(fileName).img_file_p_code(imageVO.getImg_seq()).build());
			}
			
			ifService.imageFileInsert(files, imageVO.getImg_seq());
			
		}
		
		
		int ret = imDao.update(imageVO);
		
		return ret;
	}

	public int delete2(String img_seq_str) {
		// TODO Auto-generated method stub
		
		long img_seq = Long.valueOf(img_seq_str);
		
		ImageFilesVO ifVO = ifDao.findBySeqForVO(img_seq);
		
		if(ifVO.getImg_file_origin_name() != null) {
			fService.file_delete(ifVO.getImg_file_origin_name());
		}
		
		return ifDao.delete(img_seq);
	}
	
	
	

}
