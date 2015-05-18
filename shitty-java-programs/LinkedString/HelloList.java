// test class for my linked list

class HelloList {
    public static void main(String[] args) {
        LinkedString list = new LinkedString();
        list.append("OMG");
        list.append("LOL");
        list.append("WTF");
        list.append("LMAO");
        System.out.println(list.toString());
        list.prepend("ROFLCOPTOR");
        System.out.println(list.toString());
        System.out.println(list.getAt(3));
    }
}