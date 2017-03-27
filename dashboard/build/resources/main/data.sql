INSERT INTO dyn_user (ID, LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, ACTIVATED)
VALUES (1, 'admin', '$2a$10$hvrmEKluprPI9dZugd/gOe8vFx.Ro3DbOe1QjjQb5LuV079aMmKZC', 'Administrator',
        'Admin', 'admin@localhost.com', TRUE);


INSERT INTO dyn_authority (NAME) VALUES ('ROLE_ADMINISTRADOR');

INSERT INTO dyn_user_authority (USER_ID, AUTHORITY_NAME) VALUES (1, 'ROLE_ADMINISTRADOR');