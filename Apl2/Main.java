import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Scanner;

public class Main {
    // Main class

    // Read file and display a message informing whether the operation occurred correctly or not
    public static boolean readFile(CircleLinkedList file, String[] op) {
        if(lenIsValid(op, 2)) {
            String fileName = op[1];
            try (BufferedReader fileScan = new BufferedReader(new FileReader(fileName))) {
                String line;

                while ((line = fileScan.readLine()) != null) file.insertLine(line);
                System.out.println("File read successfully!");
                return true;
            } catch (IOException e) {
                System.out.println("Couldn't open file.");
            }
        }
        return false;
    }

    // Write linked list on file and display a message informing whether the operation occurred correctly or not
    public static boolean writeFile(CircleLinkedList file, String[] op) {
        if(lenIsValid(op, 2)) {
            String fileName = op[1];
            try (BufferedWriter fileScan = new BufferedWriter(new FileWriter(fileName))) {
                Node aux = file.getHead();

                do {
                    fileScan.write(aux.getLine());
                    fileScan.newLine();
                    aux = aux.getNext();
                } while (aux != file.getHead());

                System.out.println("All changes saved.");
                return true;
            } catch (IOException e) {
                System.out.println("Couldn't save file.");
            }
        }
        return false;
    }

    //
    public static void help(CircleLinkedList help) {
        help.insertLine(":e fileName.ext        | read file.");
        help.insertLine(":w fileName.ext        | save file.");
        help.insertLine(":q!                    | leave without saving.");
        help.insertLine(":v lineBegin lineEnd   | select excerpt from text.");
        help.insertLine(":y                     | copy excerpt.");
        help.insertLine(":c                     | cut excerpt.");
        help.insertLine(":p lineBegin           | paste excerpt from lineBegin.");
        help.insertLine(":s                     | show file content.");
        help.insertLine(":s lineBegin lineEnd   | show file content from lineBegin to lineEnd");
        help.insertLine(":x line                | delete line.");
        help.insertLine(":xG line               | delete from line til the end.");
        help.insertLine(":XG line               | delete from beginning til the line.");
        help.insertLine(":/ element             | show all lines that the element appears.");
        help.insertLine(":/ element1 element2   | swap element1 for element2.");
        help.insertLine(":a line                | insert new lines starting from line (':a' to exit).");
        help.insertLine(":i line [content]      | insert new line before line.");
        help.insertLine(":help");
    }

    public static boolean lenIsValid(String[] op, int len) {
        if(op.length == len) {
            return true;
        } else {
            System.out.println("Invalid command.");
            return false;
        }
    }

    public static int intIsValid(String[] op, int pos) {
        int aux = 0;

        if(op.length > pos) {
            try {
                aux = Integer.parseInt(op[pos]);
            } catch (Exception e) {
                aux = 0;
            }
        }
        return aux;
    }

    public static boolean leave(String[] op, boolean saved) {
        if(lenIsValid(op, 1)) {
            String prompt = "";
            if(saved) {
                prompt = "Want to exit? [Y/N] ";
            } else {
                prompt = "Exit without saving? [Y/N] ";
            }

            Scanner scan = new Scanner(System.in);

            System.out.println(prompt);
            System.out.print("~ ");

            String aux = scan.nextLine();

            while (!aux.equals("Y") && !aux.equals("N")) {
                System.out.print("Invalid command. ");
                System.out.print("~ ");

                System.out.println(prompt);
                aux = scan.nextLine();
            }

            if (aux.equals("Y")) {
                System.out.println("Editor closed.");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean select(CircleLinkedList file, String[] op) {
        if(lenIsValid(op, 3)) {
            int lineBegin = 0, lineEnd = 0;
            try {
                lineBegin = Integer.parseInt(op[1]);
                lineEnd = Integer.parseInt(op[2]);

                if(lineEnd >= lineBegin && lineEnd <= file.getCount() && lineBegin > 0) {
                    file.setLineBegin(lineBegin);
                    file.setLineEnd(lineEnd);
                    System.out.println("Lines " + lineBegin + " to " + lineEnd + " selected.");
                    return true;
                } else {
                    System.out.println("Invalid line values.");
                }
            } catch (Exception e) {
                System.out.println("Invalid command.");
                return false;
            }
        }
        return false;
    }

    public static void copy(CircleLinkedList file, CircleLinkedList copy, String[] op) {
        if(lenIsValid(op, 1)) {
            String line;
            for (int i = file.getLineBegin(); i <= file.getLineEnd(); i++) {
                line = file.searchLine(i);
                copy.insertLine(line);
            }

            System.out.println("Lines between " + file.getLineBegin() + " and " + file.getLineEnd() + " copied.");
        }
    }

    public static boolean deleteExcerpt(CircleLinkedList file, String[] op) {
        if(lenIsValid(op, 1)) {
            boolean deleted = file.deleteExcerpt();
            if (deleted) {
                System.out.println("Lines between " + file.getLineBegin() + " and " + file.getLineEnd() + " deleted.");
                return true;
            } else {
                System.out.println("Unable to delete excerpt.");
            }
        }
        return false;
    }

    public static void insertExcerpt(CircleLinkedList file, CircleLinkedList copy, String[] op) {
        if(lenIsValid(op, 2)) {
            int pos = intIsValid(op, 1);

            if(pos > 0 && pos <= file.getCount()) {
                String line;
                for (int i = 1; i <= copy.getCount(); i++) {
                    line = copy.searchLine(i);
                    file.insertPos(pos + i, line);
                }
                System.out.println("Line(s) added.");
            } else {
                System.out.println("Invalid line value.");
            }
        }
    }

    public static void printFile(CircleLinkedList file, int lines, boolean number) {
        Scanner scan = new Scanner(System.in);

        int firstLine = 1, lastLine = lines;
        int count = file.getCount();

        for(int i = 0; i <= count/lines; i++) {
            file.printFile(firstLine, lastLine, number);

            if(lastLine != count) {
                System.out.println("\nWant to continue ("+ (count-lastLine) + " lines remain)? [Y/N] ");
                System.out.print("~ ");
                String aux = scan.nextLine();

                while (!aux.equals("Y") && !aux.equals("N")) {
                    System.out.print("\nInvalid command. ");
                    System.out.println("Want to continue? [Y/N] ");
                    System.out.print("~ ");

                    aux = scan.nextLine();
                }

                if (aux.equals("N")) {
                    break;
                }

                firstLine = lastLine + 1;
                lastLine += lines;

                if (lastLine > count) {
                    lastLine = count;
                }
            }
        }
    }

    public static boolean delete(CircleLinkedList file, String[] op) {
        int aux = intIsValid(op, 1);
        if(aux > 0) {
            boolean deleted = false;

            if(op[0].equals(":x")) deleted = file.deleteLine(aux);
            else if(op[0].equals(":xG")) deleted = file.deleteEnd(aux);
            else deleted = file.deleteBegin(aux);

            if (deleted) {
                if(op[0].equals(":x")) {
                    System.out.println("Line " + aux + "deleted.");
                } else {
                    System.out.println("Lines deleted.");
                }
                return true;
            }
        } else {
            System.out.println("Unable to delete.");
        }
        return false;
    }

    public static boolean element(CircleLinkedList file, String[] op) {
        if(op.length == 2) {
            if(!file.searchElement(op[1])) {
                System.out.println("Couldn't find any occurrences.");
            } else {
                System.out.println("All occurrences found.");
            }
        } else if(op.length == 3) {
            file.replaceElement(op[1], op[2]);
            System.out.println("All occurrences replaced.");
            return true;
        } else {
            System.out.println("Invalid command.");
        }
        return false;
    }

    public static boolean insertLines(CircleLinkedList file, String[] op) {
        if(lenIsValid(op, 2)) {
            Scanner scan = new Scanner(System.in);

            System.out.print("~ ");
            String line = scan.nextLine();
            int pos = intIsValid(op, 1);

            if (pos > 0) {
                while (!line.equals(":a")) {
                    pos++;
                    file.insertPos(pos, line);
                    System.out.print("~ ");
                    line = scan.nextLine();
                }
                System.out.println("New lines added.");
                return true;
            } else {
                System.out.println("Invalid line value.");
            }
        }
        return false;
    }

    public static boolean insertLine(CircleLinkedList file, String[] op) {
        if(op.length > 1) {
            int pos = intIsValid(op, 1);

            if (pos > 0) {
                String lineContent = "";

                for (int i = 2; i < op.length; i++) {
                    lineContent += op[i] + " ";
                }

                file.insertPos(pos + 1, lineContent);
                System.out.println("New line added.");
                return true;
            } else {
                System.out.println("Invalid line value.");
            }
        } else {
            System.out.println("Invalid command");
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CircleLinkedList file = new CircleLinkedList();
        CircleLinkedList copy = new CircleLinkedList();
        CircleLinkedList help = new CircleLinkedList();

        help(help);

        boolean opened = false, selected = false, saved = false;

        String[] op = {""};

        while(!op[0].equals(":q!")) {
            System.out.print("~ ");
            op = scan.nextLine().trim().split(" ");

            if(op[0].equals(":e")) {
                if(lenIsValid(op, 2)) {
                    opened = readFile(file, op);
                }
            } else if(op[0].equals(":q!")) {
                if(lenIsValid(op, 1)) {
                    boolean leaving = leave(op, saved);
                    if (!leaving) {
                        op[0] = "";
                    }
                }
            } else if(op[0].equals(":help")) {
                if(lenIsValid(op, 1)) {
                    printFile(help, 5, false);
                }
            } else if(opened) {
                if(op[0].equals(":w")) {
                    saved = writeFile(file, op);
                } else if(op[0].equals(":v")) {
                    selected = select(file, op);
                } else if(op[0].equals(":y") || op[0].equals(":c") || op[0].equals(":p")) {
                    if(selected) {
                        if(op[0].equals(":y")) {
                            copy(file, copy, op);
                        } else if(op[0].equals(":c")) {
                            selected = !deleteExcerpt(file, op);
                            saved = false;
                        } else {
                            insertExcerpt(file, copy, op);
                            saved = false;
                        }
                    } else {
                        System.out.println("No excerpt selected.");
                    }
                } else if(op[0].equals(":s")) {
                    if(op.length == 1) {
                        printFile(file, 10, true);
                    } else if(op.length == 3) {
                        int lineBegin = intIsValid(op, 1), lineEnd = intIsValid(op, 2);
                        file.printFile(lineBegin, lineEnd, true);
                    } else {
                        System.out.println("Invalid command.");
                    }
                } else if(op[0].equals(":x") || op[0].equals(":xG") || op[0].equals(":XG")) {
                    if(delete(file, op)) {
                        saved = false;
                    }
                } else if(op[0].equals(":/")) {
                    if(element(file, op)) {
                        saved = false;
                    }
                } else if(op[0].equals(":a")) {
                    if(insertLines(file, op)) {
                        saved = false;
                    }
                } else if(op[0].equals(":i")) {
                    if(insertLine(file, op)) {
                        saved = false;
                    }
                } else {
                    System.out.println("Invalid command.");
                }
            } else {
                System.out.println("No files opened.");
            }
        }
    }
}
