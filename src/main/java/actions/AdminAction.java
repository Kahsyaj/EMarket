package actions;

import beans.God;
import com.opensymphony.xwork2.ActionSupport;
import dao.GodDbManager;

public final class AdminAction extends ActionSupport {

    private God god;

    private String pseudo;

    private String password;

    public God getGod() {
        return god;
    }

    public void setGod(God god) {
        this.god = god;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String doDisplay() {
        if (this.god == null) {
            return ActionSupport.ERROR;
        } else {
            return ActionSupport.SUCCESS;
        }
    }

    public String doLog() {
        if (this.password != null && this.pseudo != null) {
            this.god = new GodDbManager().read(this.pseudo, this.password);

            if (this.god != null) {
                return ActionSupport.SUCCESS;
            }
        }

        return ActionSupport.ERROR;
    }


}
