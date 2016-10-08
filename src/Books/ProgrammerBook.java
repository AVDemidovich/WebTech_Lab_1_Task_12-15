package Books;

/**
 * Created by Alexander_Demidovich on 10/8/2016.
 */
public class ProgrammerBook {
    private String language;
    private int level;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this){
            return true;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        if (!super.equals(obj)) return false;

        ProgrammerBook programmerBook = (ProgrammerBook) obj;

        if (this.getLevel() != programmerBook.getLevel()) return false;
        return  this.getLanguage().equals(programmerBook.getLanguage());
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode() ;
        result = PRIME * result + this.getLanguage().hashCode() + this.getLevel();
        return result;
    }

    @Override
    public String toString() {
        return "Class:ProgrammerBook, Parent:Book, " + "language = '" + language + '\'' + ", level=" + level;
    }
}
