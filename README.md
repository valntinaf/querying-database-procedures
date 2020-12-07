# querying-database-procedures
Querying database procedures test with Oracle and Java SE

## Procedure

> In BOOKS_TAPI

```sql
PROCEDURE get_books
(p_libros    OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN p_libros FOR 
      SELECT b.title, b.author_first_name, b.author_last_name, b.rating
      FROM books b;
END;
```

## Implementation

> In RepositoryLibrary class
```java
public static List<Book> getAllBooks() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppForGettingBooksPU");
            EntityManager em = emf.createEntityManager();
            StoredProcedureQuery query = em.createStoredProcedureQuery("BOOKS_TAPI.get_books")
                    .registerStoredProcedureParameter(
                            0,
                            String.class,
                            ParameterMode.REF_CURSOR
                    );
    query.execute();

    List<Object[]> booksObj = query.getResultList();
    List<Book> books = new ArrayList<>();
    for (Object[] b : booksObj) {
        Book book = new Book();
        book.setTitle(b[0].toString());
        book.setAuthorFirstName(b[1].toString());
        book.setAuthorLastName(b[2].toString());
        book.setRating(Integer.parseInt(b[3].toString()));
        books.add(book);
    }
    return books;

    }
```

## Results example
![Results example](https://i.ibb.co/Vgm1cbB/image.png "Results example")

