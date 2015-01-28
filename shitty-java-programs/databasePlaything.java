class databasePlaything {
    // constructor
    // public databasePlaything {

    // }

    // public static bool valid_age(int age) {

    // }

    public static boolean validName(String name) {
        if (name.length() > 0 && name.length() < 64) {
            return true;
        }
        else {
            return false;
        }
    }

    // public static bool database_exists(String name) {

    // }

    // public static void create_database(String db) {

    // }

    // public static void insert_data(String name, int age) {

    // }

    // public static void view_data(String name, int age) {

    // }

    public static void takeInput() {
        String userInput = "";
        String name = "";
        String age = "";
        while (userInput != "exit" && !validName(userInput)) {
            userInput = System.console().readLine("Name, please: ");
            name = userInput;
        }
        // while (userInput != "exit" && validAge(userInput)) {
        //     String userInput = System.console().readLine("Age, please: ");
        //     age = userInput;
        // }
        System.out.println(name);
    }
    
    public static void main(String[] args) {
        takeInput();
    }

}