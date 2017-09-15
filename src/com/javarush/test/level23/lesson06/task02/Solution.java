package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public final static class Constants {
        public final static String SERVER_NOT_ACCESSIBLE = "Server is not accessible for now.";
        public final static String UNAUTHORIZED_ACESSIBLE = "User is not authorized.";
        public final static String USER_BANNED = "User is banned.";
        public final static String RESTRICTION = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SERVER_NOT_ACCESSIBLE);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SERVER_NOT_ACCESSIBLE, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.UNAUTHORIZED_ACESSIBLE);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.UNAUTHORIZED_ACESSIBLE, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.USER_BANNED);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.USER_BANNED, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.RESTRICTION);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.RESTRICTION, cause);
        }
    }
}
