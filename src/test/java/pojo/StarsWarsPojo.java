package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;



// the run class is under get package and StarsWars class
public class StarsWarsPojo {
    private int count;
    private String next;
    private String previous;
    private List<StarsWarsCharactersPojo> results;


//    private List<Map<String, Object>> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

//    public List<Map<String, Object>> getResults() {
//        return results;
//    }
//
//    public void setResults(List<Map<String, Object>> results) {
//        this.results = results;
//    }


    public List<StarsWarsCharactersPojo> getResults() {
        return results;
    }

    public void setResults(List<StarsWarsCharactersPojo> results) {
        this.results = results;
    }
}
