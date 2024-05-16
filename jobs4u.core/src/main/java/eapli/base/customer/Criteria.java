package eapli.base.customer;

public class Criteria<T> {
    String description;
    T value;
    Class<T> type;

    public Criteria(String description, Class<T> clazz) {
        // Construtor da classe Criteria.
        // Recebe uma descrição e uma classe como parâmetros.
        // A descrição é uma String que representa a descrição do critério.
        // A classe é o tipo de dado que o critério representa.

        this.description = description;
        // Inicializa o atributo description com a descrição fornecida.

        this.type = clazz;
        // Inicializa o atributo type com a classe fornecida.
    }

    public String description() {
        // Método para obter a descrição do critério.
        return description;
        // Retorna a descrição do critério.
    }

    public T value() {
        // Método para obter o valor do critério.
        return value;
        // Retorna o valor do critério.
    }

    public void value(T value) {
        // Método para definir o valor do critério.
        this.value = value;
        // Define o valor do critério com o valor fornecido.
    }

    public Class<T> getGenericType() {
        // Método para obter o tipo genérico do critério.
        return type;
        // Retorna a classe que representa o tipo genérico do critério.
    }
}
