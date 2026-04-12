public interface BookListTad {

    //Inserção
    void addFirst(int id);
    void addLast(int id);
    void  insertAt(int index,int id);
    //Remoção
    void remove (int id);
    void removeFirst();
    void removeLast();
    void removeAt(int index);
    //Busca
    int find (int id);
    int get (int index);
    void set(int index, int id);
}
