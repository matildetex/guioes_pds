package lab08.Ex1;

import java.sql.Date;

// Interface base
interface DecoratorInterface {
    void start(Date date);
    void terminate(Date date);
    void work();
}
