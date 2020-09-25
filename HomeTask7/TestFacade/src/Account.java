import java.io.IOException;

public class Account {

    private int id;
    private String holder;
    private int amount;

    public Account(int i, String s) {
        this.id = i;
        this.holder = s;
    }

    public Account() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getAmount()  {

        return amount;
    }

}
