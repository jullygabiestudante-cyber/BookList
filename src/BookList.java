public class BookList implements BookListTad {
    private int[] livros;
    private int size;
    private int capacidade;
    private String nomeLista;

    public BookList(int capacidade, String nomeLista) {
        this.capacidade = capacidade;
        this.livros = new int[capacidade];
        this.size = 0;
        this.nomeLista = nomeLista;
    }

    @Override
    public void addFirst(int id) {
        if (isFull()) {
            System.out.println("Erro: Lista de livros cheia!");
            return;
        }
        // Deslocamento para a DIREITA (do fim para o começo)
        for (int i = size; i > 0; i--) {
            livros[i] = livros[i - 1];
        }
        livros[0] = id;
        size++;
    }

    @Override
    public void addLast(int id) {
        if (isFull()) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        livros[size++] = id;
    }

    @Override
    public void insertAt(int index, int id) {
        if (index < 0 || index > size || isFull()) {
            System.out.println("Índice inválido ou lista cheia!");
            return;
        }
        for (int i = size; i > index; i--) {
            livros[i] = livros[i - 1];
        }
        livros[index] = id;
        size++;
    }

    @Override
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Índice inexistente!");
            return;
        }
        // Deslocamento para a ESQUERDA (do ponto removido até o fim)
        for (int i = index; i < size - 1; i++) {
            livros[i] = livros[i + 1];
        }
        size--;
    }

    @Override
    public void remove(int id) {
        int pos = find(id);
        if (pos != -1) removeAt(pos);
    }

    @Override
    public int find(int id) {
        for (int i = 0; i < size; i++) {
            if (livros[i] == id) return i;
        }
        return -1;
    }

    @Override
    public void removeFirst() { removeAt(0); }

    @Override
    public void removeLast() { if (size > 0) size--; }

    @Override
    public int get(int index) {
        return (index >= 0 && index < size) ? livros[index] : -1;
    }

    @Override
    public void set(int index, int id) {
        if (index >= 0 && index < size) livros[index] = id;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == capacidade; }

    public void display() {
        System.out.print("BookList [" + nomeLista + "]: ");
        for (int i = 0; i < size; i++) System.out.print(livros[i] + " ");
        System.out.println();
    }
}