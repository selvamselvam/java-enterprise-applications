create or replace FUNCTION f (n INTEGER)
  RETURN INTEGER
IS
BEGIN
  
    RETURN n *n;
END;