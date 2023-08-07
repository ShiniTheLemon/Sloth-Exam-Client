package com.diaas.student.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;

import com.diaas.student.dto.GradedPapers;
import com.diaas.student.dto.StudentInfo;
import com.diaas.student.entities.AnswerBank;
import com.diaas.student.entities.ExamScores;
import com.diaas.student.entities.Photo;
import com.diaas.student.entities.UserInfo;
import com.diaas.student.entities.Users;
import com.diaas.student.entities.pojo.AnswerBankPojo;
import com.diaas.student.repository.StudentRepository;
@Service
public class StudentServiceImp implements StudentService {
@Autowired
StudentRepository studentRepo;

//saves students answers to the database
    @Transactional
	@Override
	public int insertSingleChoiceAnswers(AnswerBankPojo pojo) {
		// TODO Auto-generated method stub
		int counter=0;
		AnswerBank answers=new AnswerBank();
		int size=pojo.getAnswers().size();
		for(int i=0;i<size;i++) {
			answers.setAnswers(pojo.getAnswers().get(i));
			answers.setExam_code(pojo.getExam_code().get(i));
			answers.setPoints(0);
			answers.setUser_id(pojo.getUser_id());
			
			//call database insert method recursively 
			 counter=studentRepo.insertIntoAnswerBank(answers);
		}
		
		ExamScores scores=new ExamScores();
		scores.setExam_code(answers.getExam_code());
		scores.setStatus(0);
		scores.setUser_id(answers.getUser_id());
		//insert into exam scores table
		studentRepo.insertScoreInfo(scores);
		
		System.out.println("The database method has been called "+ counter+" times");
		System.out.println("Exam Scores object value "+ scores);
		return counter;
	}

	@Override
	public int InsertMultipleChoiceAnswers(AnswerBankPojo pojo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	//collects all user id's from exam scores table
	//uses the id's to get relevant user infromation
	@Override
	public ArrayList<StudentInfo> getUserInfo(String exam_code) {
		// TODO Auto-generated method stub
		List<ExamScores> scores= studentRepo.findByExamCode(exam_code);
		ArrayList<UserInfo>userInfo = new ArrayList();
		ExamScores localScores=new ExamScores();
		for(int i=0;i<scores.size();i++) {
			localScores= scores.get(i);		
			UserInfo info=studentRepo.findByUserId(localScores.getUser_id());
			userInfo.add(info);
		}
		return getStudentInfo(userInfo,exam_code);
	}

	
	
	//returns a list of user info plus the related exam code
	private ArrayList<StudentInfo> getStudentInfo(ArrayList<UserInfo> info,String exam_code) {
		// TODO Auto-generated method stub
		System.out.println("parameter obtained "+ info);
		ArrayList<StudentInfo>studentInfo=new ArrayList();
		
		UserInfo localInfo=new UserInfo();
		for(int i=0;i<info.size();i++) {
			StudentInfo stuInfo=new StudentInfo();
			 //localInfo=info.get(i);
			stuInfo.setExam_code(exam_code);
			stuInfo.setFirst_name(info.get(i).getFirst_name());
			stuInfo.setLast_name(info.get(i).getLast_name());
			stuInfo.setUser_id(info.get(i).getUser_id());
			studentInfo.add(stuInfo);;
			System.out.println("The get student is traversing");
			System.out.println("local info value "+ localInfo);
			System.out.println("student info value "+ studentInfo);
		}
		return studentInfo;
	}

	@Override
	//checks if paper is graded and then acts accordingly 
	public int gradeProcessor(GradedPapers paper) {
		// TODO Auto-generated method stub
		int returnValue=0;
		int status1= studentRepo.findByExamCodeAndUserId(paper.getSection1(), paper.getUser_id()).getStatus();
		int status2= studentRepo.findByExamCodeAndUserId(paper.getExam_code(), paper.getUser_id()).getStatus();
		if(status1==0&&status2==0) {
			List<Integer>Ids=studentRepo.showIdByUserIdAndExam_code(paper.getUser_id(), paper.getSection1());
			List<AnswerBank>answers=studentRepo.showAnswersByUserIdAndExam_code(paper.getUser_id(), paper.getSection1());
			int counter=0;
			for(int i=0;i<Ids.size();i++) {
			
				AnswerBank localAnswers= answers.get(i);
				String coreectAnswers=paper.getAnswers().get(i);
				if(localAnswers.getAnswers().equals(coreectAnswers)) {
					studentRepo.insertPointsByid(Ids.get(i), 2);
					counter+=2;
				}
			}
			ExamScores scores=new ExamScores();
			scores.setExam_code(paper.getSection1());
			scores.setTotal(counter);
			scores.setStatus(1);
			scores.setUser_id(paper.getUser_id());
			studentRepo.insertTotal(scores);
			
			int counter2=0;
			List<Integer>Ids2=studentRepo.showIdByUserIdAndExam_code(paper.getUser_id(), paper.getExam_code());
			for(int i=0;i<Ids2.size();i++) {

					studentRepo.insertPointsByid(Ids2.get(i),paper.getPoints().get(i));
					counter2+=paper.getPoints().get(i);
			
			}
			ExamScores scores2=new ExamScores();
			scores2.setExam_code(paper.getExam_code());
			scores2.setTotal(counter2);
			scores2.setStatus(1);
			scores2.setUser_id(paper.getUser_id());
			studentRepo.insertTotal(scores2);
			returnValue=1;
		}else {
			
				int counter2=0;
				List<Integer>Ids2=studentRepo.showIdByUserIdAndExam_code(paper.getUser_id(), paper.getExam_code());
				for(int i=0;i<Ids2.size();i++) {

						studentRepo.insertPointsByid(Ids2.get(i),paper.getPoints().get(i));
						counter2+=paper.getPoints().get(i);
				
				}
				ExamScores scores2=new ExamScores();
				scores2.setExam_code(paper.getExam_code());
				scores2.setTotal(counter2);
				scores2.setStatus(1);
				scores2.setUser_id(paper.getUser_id());
				studentRepo.insertTotal(scores2);
				returnValue=1;
		
			
			}

		return returnValue;
	}

	//logs in user and creates session ids
	@Override
	public String login(Users user, HttpSession session) {
	
	
			Users  data= studentRepo.findUserByUserId(user.getId());
		
		if(data==null) {
			String msg=user.getId()+" Is not a valid User id!";
			return msg;
		}else {
			if(user.getPassword().equals(data.getPassword())) {
				if(data.getRole()==1) {
					UserInfo localUserObj= studentRepo.findByUserId(user.getId());
					int dept_id=localUserObj.getDept_id();
					String avatar=localUserObj.getAvatar();
					String email=localUserObj.getEmail();
					int user_id=user.getId();
					
					session.setAttribute("dept_id", dept_id);
					session.setAttribute("user_id", user_id);
					session.setAttribute("avatar", avatar);
					session.setAttribute("email", email);
					session.setAttribute("role", data.getRole());
					
					
				}else {
					session.setAttribute("user_id", data.getId());
					session.setAttribute("role", data.getRole());
				}
				return null;
			}else {
				String msg=user.getPassword()+" Is incorrect!";
				return msg;
			}
		}
		
	}

	//deprecated method
	@Override
	public String UpdateInfo(UserInfo info, MultipartFile file) throws IOException {
//		if(file.isEmpty()) {
//			System.out.println("The file is empty");
//			studentRepo.updateInfoById(info);
//		}else {
//			System.out.println("The file is not empty");
//			InputStream inputStream=file.getInputStream();
//			byte[]avatar=new byte[(int)file.getSize()];
//			inputStream.read(avatar);
//	
//			info.setAvatar(avatar);
//			inputStream.close();
//			System.out.println("The avatar data  "+ info.getAvatar());
//			studentRepo.updateInfoById(info);
//			
//		}

		
		
		return "Information has been updated successfully";
	}

	//deprecated method
	@Override
	public String getAvatar(UserInfo info,HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
//		byte[]data=info.getAvatar();
//		
//		response.setContentType("image/jpeg");
//		response.setCharacterEncoding("UTF-8");
//		OutputStream outPut=response.getOutputStream();
//		InputStream input=new ByteArrayInputStream(data);
//		int len=0;
//		byte[]buff= new byte[1024];
//		while((len=input.read(buff,0,1024))!=-1) {
//			outPut.write(buff, 0, len);
//		}
//        byte[] imageBytes = outPut.toString();
//        String base64Image = Base64.getEncoder().wrap(outPut).toString();
//		outPut.close();
//		input.close();
		return null;
	}
	
	//saves an images to disk
    @Override
    public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        photo.setPath(absolutePath + "/src/main/resources/static/img/");
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(photo.getPath() + imageFile.getOriginalFilename());
        Files.write(path, bytes);
        //kafkaTemplate.send("photoIn", path.normalize().toString());
    }

}
