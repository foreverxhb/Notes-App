import java.io.*;
import java.util.*;
public class NotesApp {
    static final String notes = "notes.txt";
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                addNote(sc);
                break;
                case 2:
                viewNotes();
                break;
                case 3:
                System.out.println("Exiting... GoodBye!");
                break;            
                default:
                System.out.println("Invalid Input, Try Again!");
            }
        } while(choice!=3);
        sc.close();
    }


private static void addNote(Scanner sc){
    System.out.println("Enter your note: ");
    String note = sc.nextLine();
    //used to append notes to a file
    //append mode true to avoid overwriting existing notes
try(FileWriter writer = new FileWriter(notes,true)) 
{
    writer.write(note+ System.lineSeparator());
    System.out.println("-Note saved successfully.");
}catch (IOException e){
    System.out.println("Error writing to file: "+e.getMessage());
}
}

private static void viewNotes(){
           System.out.println("\n--- Saved Notes ---");
           //used to read notes line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(notes))) {
            String line;
            boolean isEmpty = true;

            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                isEmpty = false;
            }

            if (isEmpty) {
                System.out.println("No notes found.");
            }
        }catch (FileNotFoundException e) {
            System.out.println("No notes file found. Add a note first.");
        }catch (IOException e) {
            System.out.println("Error reading from file: " +e.getMessage());
        }
    }
}
