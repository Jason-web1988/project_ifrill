package project_ifrill.dto;

import java.util.Date;

public class QnA {
    private int no; // 번호
    private String subject; // 제목
    private String content; // 내용
    private String rep; // 답변
    private String id; // 작성자 아이디
    private String repYN; // 답변여부 1:답변무, 2:답변유
    private Date writeDate; // 작성일

    public QnA() {}

    public QnA(String subject, String content, String id) {
        this.subject = subject;
        this.content = content;
        this.id = id;
    }

    public QnA(int no, String subject, String content, String rep, String id, String repYN, Date writeDate) {
        this.no = no;
        this.subject = subject;
        this.content = content;
        this.rep = rep;
        this.id = id;
        this.repYN = repYN;
        this.writeDate = writeDate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepYN() {
        return repYN;
    }

    public void setRepYN(String repYN) {
        this.repYN = repYN;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    @Override
    public String toString() {
        return String.format("QnA [no=%s, subject=%s, content=%s, rep=%s, id=%s, repYN=%s, writeDate=%s]", no, subject,
                content, rep, id, repYN, writeDate);
    }

}
