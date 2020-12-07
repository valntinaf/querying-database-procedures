PROCEDURE get_books
(p_libros    OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN p_libros FOR 
      SELECT b.title, b.author_first_name, b.author_last_name, b.rating
      FROM books b;
END;

