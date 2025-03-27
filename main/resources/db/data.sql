INSERT INTO USERS (user_name, nick_name, gender, is_active, type, description, created_at, updated_at, deleted_at)
VALUES ('user1', 'Nick1', 'Male', TRUE, 'normal', 'User 1 description', NOW(), NOW(), NOW()),
       ('user2', 'Nick2', 'Female', TRUE, 'premium', 'User 2 description', NOW(), NOW(), NOW()),
       ('user3', 'Nick3', 'Male', FALSE, 'normal', 'User 3 description', NOW(), NOW(), NOW()),
       ('user4', 'Nick4', 'Female', TRUE, 'admin', 'User 4 description', NOW(), NOW(), NOW()),
       ('user5', 'Nick5', 'Male', TRUE, 'normal', 'User 5 description', NOW(), NOW(), NOW()),
       ('user6', 'Nick6', 'Female', FALSE, 'premium', 'User 6 description', NOW(), NOW(), NOW()),
       ('user7', 'Nick7', 'Male', TRUE, 'normal', 'User 7 description', NOW(), NOW(), NOW()),
       ('user8', 'Nick8', 'Female', FALSE, 'admin', 'User 8 description', NOW(), NOW(), NOW()),
       ('user9', 'Nick9', 'Male', TRUE, 'premium', 'User 9 description', NOW(), NOW(), NOW()),
       ('user10', 'Nick10', 'Female', FALSE, 'normal', 'User 10 description', NOW(), NOW(), NOW())
    ON CONFLICT (user_name) DO NOTHING;

INSERT INTO ADMINS (user_name, nick_name, password, created_at, updated_at, deleted_at)
VALUES ('admin1', 'AdminNick1', 'hashed_password_1', NOW(), NOW(), NOW()),
       ('admin2', 'AdminNick2', 'hashed_password_2', NOW(), NOW(), NOW()),
       ('admin3', 'AdminNick3', 'hashed_password_3', NOW(), NOW(), NOW()),
       ('admin4', 'AdminNick4', 'hashed_password_4', NOW(), NOW(), NOW())
    ON CONFLICT (user_name) DO NOTHING;

