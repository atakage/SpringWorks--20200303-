package com.biz.gallery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.domain.ImageVO;
import com.biz.gallery.repository.ImageDao;
import com.biz.gallery.repository.ImageFileDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("imgServiceV1")
public class ImageService {

	/*
	 * 기존방법:setter 주입방식
	 * 
	 * @Autowired 클래스 객체
	 * 
	 */
	
	protected final ImageFileDao ifDao;
	protected final ImageDao imDao;
	protected final FileService fService;
	protected final ImageFileService ifService;

	/*
	 * 
	 * 생성자에서 객체 주입 사용하는 객체를 final로 선언하여 보호할 수 있고 혹시 모를 해킹에 의한 데이터 변조를 막을 수 있음 클래스의
	 * 교차참조를 컴파일러 차원에서 방지할 수 있음 코드가 다소 번잡스러울 수 있지만 setter주입보다는 constructor(생성자)주입
	 * 방식을 사용 인텔리제이(intelij)에서는 setter 주입방식을 사용하면 ide가 심각한 경고를 보임
	 * 
	 */
	@Autowired
	public ImageService(ImageDao imDao, FileService fService, ImageFileService ifService, ImageFileDao ifDao) {
		super();
		this.imDao = imDao;
		this.fService = fService;
		this.ifService = ifService;
		this.ifDao = ifDao;
	}

	public List<ImageVO> selectAll() {

		return imDao.selectAll();

	}

	public int insert(ImageVO imageVO) {

		// 1. 파일이름 리스트를 추출
		List<String> fileList = imageVO.getImg_file_upload_name();

		// 리스트가 있는지 검사하여 flag 세팅
		boolean yesList = fileList != null && fileList.size() > 0;

		// 2. 리스트가 있는지 검사
		if (yesList) {
			imageVO.setImg_file(imageVO.getImg_file_upload_name().get(0));// 4. 여러개의 파일 중 0번째 파일을 대표 파일로 지정

		}

		// 5. tbl_gallery에 본문 데이터 insert
		int ret = imDao.insert(imageVO);
		long img_p_code = imageVO.getImg_seq();

		// 6. 파일 이름들을 저장하기 위해서 리스트 생성

		List<ImageFilesVO> files = new ArrayList<ImageFilesVO>();

		// 7. 다시 리스트가 있는지 검사
		if (yesList) {

			// 8. 파일이름을 DB에 저장하기 위한 List를 작성
			for (String fileName : fileList) {

				files.add(ImageFilesVO.builder().img_file_p_code(img_p_code).img_file_upload_name(fileName)
						.img_file_origin_name(fileName.substring(36)).build());

			}

			// 9. 파일 정보를 tbl_images에 bulk insert
			ifService.imageFileInsert(files, img_p_code);

		}

		log.debug("로그그" + imageVO.toString());
		return ret;

	}

	/*
	 * 일반적으로 dao.insert(vo)를 호출했을 때 vo에 담아서 전달한 값은 insert가 수행된 후에 볼 수 있으나 seq처럼
	 * SQL에서 생성된 값은 확인 불가능
	 * 
	 * 
	 * 
	 * 이 값을 insert()후에 사용해야할 경우가 잇음 이때는 dao, mapper, selectkey를 사용하여 값을 생성하면
	 * insert()후에 그 값ㅇ들 사용할 수 잇음
	 */
	public int insert(ImageVO imageVO, String dummy) {

		List<String> fileList = imageVO.getImg_file_upload_name();

		if (fileList != null && fileList.size() > 0) {
			imageVO.setImg_file(imageVO.getImg_file_upload_name().get(0));// 여러개의 파일 중 0번째 파일을 대표 파일로 업로드
		}

		// 1. tbl_gallery에 데이터 insert
		int ret = imDao.insert(imageVO);

		// 2. 파일 이름들을 ImageFilesVO의 리스트에 생성
		// ImageFilesVO에 img_file_p_code 컬럼에 tbl_gallery의 seq값을 추가해 리스트 새엉
		List<ImageFilesVO> files = new ArrayList<ImageFilesVO>();

		if (fileList != null) {

			for (String fileName : fileList) {
				files.add(ImageFilesVO.builder().img_file_upload_name(fileName).img_file_p_code(imageVO.getImg_seq())
						.build());

			}

			ifService.imageFileInsert(files, imageVO.getImg_seq()); // 3. 파일 정보를 tbl_images에 insert

		}

		log.debug(imageVO.toString());
		return ret;
	}

	public ImageVO findBySeq(String img_seq) {
		// TODO Auto-generated method stub

		ImageVO imgVO = imDao.findBySeq(img_seq);
		log.debug(imgVO.toString());
		return imgVO;
	}

	// 혹시 파일이 변경되면 기존파일을 먼저 제거하고 새로운 파일로 등록

	public int update(ImageVO imageVO) {
		
		
		long img_seq = imageVO.getImg_seq();
		String img_file = imageVO.getImg_file();
		
		ImageVO imgVO = imDao.findBySeqAndFile(img_seq, img_file);
		
		
		
		if(imgVO == null) {
			
			ImageVO oldImageVO = imDao.findBySeq(img_seq + "");

			if(oldImageVO.getImg_file() != null) {
				fService.file_delete(oldImageVO.getImg_file());
			}
			
			
		}
		
		
		// TODO Auto-generated method stub

		List<String> fileNames = imageVO.getImg_file_upload_name();

		if (fileNames != null && fileNames.size() > 0) {
			
			List<ImageFilesVO> files = new ArrayList<ImageFilesVO>();
			
			for (String fileName : fileNames) {
				
				ImageFilesVO vo = ImageFilesVO.builder().img_file_origin_name(fileName.substring(36)).img_file_upload_name(fileName).build();
				files.add(vo);
			}
			ifService.imageFileInsert(files, imageVO.getImg_seq());
			
		}

		
		
		int ret = imDao.update(imageVO);

		return ret;
	}

	public int delete(String img_seq) {
		// TODO Auto-generated method stub

		ImageVO imgVO = imDao.findBySeq(img_seq);

		if (imgVO.getImg_file() != null) {
			fService.file_delete(imgVO.getImg_file());
		}

		return imDao.delete(img_seq);
	}

	public List<ImageFilesVO> files_up(MultipartHttpServletRequest mFiles) {

		List<ImageFilesVO> fileNames = new ArrayList<ImageFilesVO>();

		for (MultipartFile file : mFiles.getFiles("files")) {

			ImageFilesVO imVO = ImageFilesVO.builder().img_file_origin_name(file.getOriginalFilename())
					.img_file_upload_name(fService.file_up(file)).build();

			// 1개의 파일을 업로드하고
			// 저장한 파일이름을 return
			fileNames.add(imVO);

		}

		// list를 return
		return fileNames;
	}

}
