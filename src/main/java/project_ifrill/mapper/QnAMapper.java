package project_ifrill.mapper;

import java.util.ArrayList;

import project_ifrill.dto.QnA;

public interface QnAMapper {
    ArrayList<QnA> listQna(String id);  
    QnA getQnA(int no);                
    int insertqna(QnA qna);
    
    //관리자 모드
    ArrayList<QnA> listAllQnA();
    int updateQnA(QnA qna);
}
