/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package author;

/**
 *
 * @author Tuan
 */
public class Authors {
    private String authorID, name;

    public Authors() {
    }

    public Authors(String authorID, String name) {
        this.authorID = authorID;
        this.name = name;
    }

    public String getAuthorID() {
        return authorID;
    }

    public String getName() {
        return name;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" + "authorID=" + authorID + ", name=" + name + '}';
    }
    
}
