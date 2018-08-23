import javafx.fxml.LoadException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException, IOException {
        //New instance of JDABuilder (Wrapper for Discord)
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        System.out.println("Getting Access Token");
        //File Reader to get a your app token
        BufferedReader tokenReader = new BufferedReader(new FileReader(".\\src\\main\\token.txt"));
        System.out.println("Access Token File found Aquired");
        //Reads file to obtain token
        String token = tokenReader.readLine();
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.buildAsync();
    }
    /*
    * HAVE NOT FINSIHED COMMENTING BUT YOU CAN PROBS GET THE IDEA
    * */
    @Override
    public void onMessageReceived (MessageReceivedEvent event){
        System.out.println("## Message recieved ## " +
                "Sender: " + event.getAuthor().getName() +
                ", \"" + event.getMessage().getContentDisplay() + "\"");

        if(event.getMessage().getContentRaw().equals("!Rping")){
            event.getChannel().sendMessage("Pong , I'm awake!").queue();
        }

        if(event.getMessage().getContentRaw().contains("!reverse")){
            String plainText = event.getMessage().getContentRaw();
            plainText = plainText.toLowerCase();
            String targetText = plainText.replace("!reverse ","");
            String reverseText = "";
            for(int i = targetText.length() -1 ; i >= 0; i--) {
                reverseText = reverseText + targetText.charAt(i);
            }
                event.getChannel().sendMessage("The reverse of your text is: " + reverseText).queue();

        }
    }
}
