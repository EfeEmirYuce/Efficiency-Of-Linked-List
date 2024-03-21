public class Runner {
    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<>();
        FileManager.writeFile("Source.txt");  //these are for randomly creating source and search files
        FileManager.writeFile("Search.txt");  //if you wish to use your own files you can comment out them
        list.insertFromFile("Source.txt");
        list.display();
        list.searchFromFile("Search.txt",false);
        list.searchFromFile("Search.txt",true);
        list.display();
    }
}

