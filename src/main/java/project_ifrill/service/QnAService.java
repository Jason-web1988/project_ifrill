package project_ifrill.service;

import java.util.ArrayList;

import project_ifrill.dto.QnA;

public interface QnAService {
	public ArrayList<QnA> listQna(String id);

	public QnA getQnA(int no);

	public int insertqna(QnA qna);

	public ArrayList<QnA> listAllQnA();

	public int updateQnA(QnA qna);
}
