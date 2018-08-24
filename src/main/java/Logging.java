import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Logging {
    Boolean allowLogging = false;
    public void consoleLogging (MessageReceivedEvent event) {
            System.out.println("## Message recieved ## " +
                    "Sender: " + event.getAuthor().getName() +
                    ", \"" + event.getMessage().getContentDisplay() + "\"");
    }
    public Boolean getLoggingStatus(){
        return allowLogging;
    }
    public void setStatus(Boolean status) {
        if (status == true) {
            allowLogging = true;
        } else if (status == false){
            allowLogging = false;
        }
    }
}
