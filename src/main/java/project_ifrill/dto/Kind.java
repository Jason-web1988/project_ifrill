package project_ifrill.dto;

public class Kind {
    private int no;
    private String name;

    public Kind() {
    }

    public Kind(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + no;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Kind other = (Kind) obj;
        if (no != other.no)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Kind [no=%s, name=%s]", no, name);
    }

}
