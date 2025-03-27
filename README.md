환경
사용스택
JDK21, Springboot, Kotlin, Spring-Security, Postgresql

유저 게시판 기능 구현
이전 리액트 프로젝트 기준으로 코틀린으로 CRUD 기능 구현

[API]
User & Authentication API Documentation

1. User Management
1.1 Get User Details
Endpoint: GET /users

Request Body:

{
    "username": "acro1@acrofuture.com"
}
Response:

{
    "resultCode": "A200",
    "resultMessage": "Success",
    "resultData": {
        "message": "User details retrieved successfully",
        "user": {
            "username": "acro1@acrofuture.com",
            "nickName": "aa",
            "gender": "female",
            "isActive": true,
            "type": "back",
            "description": "this is description1"
        }
    }
}
1.2 Create User
Endpoint: POST /users/create

Request Body:

{
    "username": "acro1@acrofuture.com",
    "nickName": "aa",
    "gender": "female",
    "isActive": true,
    "type": "back",
    "description": "this is description1"
}
Response:

{
    "resultCode": "A200",
    "resultMessage": "Success",
    "resultData": {
        "message": "User create successful",
        "user": {
            "username": "acro1@acrofuture.com",
            "nickName": "aa",
            "gender": "female",
            "isActive": true,
            "type": "back",
            "description": "this is description1"
        }
    }
}
1.3 Edit User
Endpoint: PUT /users/edit

Request Body:

{
    "username": "acro1@acrofuture.com",
    "nickName": "aa",
    "gender": "female",
    "isActive": true,
    "type": "back",
    "description": "this is updated description"
}
Response:

{
    "resultCode": "A200",
    "resultMessage": "Success",
    "resultData": {
        "message": "User edit successful",
        "user": {
            "username": "acro1@acrofuture.com",
            "nickName": "aa",
            "gender": "female",
            "isActive": true,
            "type": "back",
            "description": "this is updated description"
        }
    }
}
1.4 Delete User (Soft Delete)
Endpoint: DELETE /users/delete

Request Body:

{
    "username": "acro1@acrofuture.com"
}
Response:

{
    "resultCode": "A200",
    "resultMessage": "Success",
    "resultData": {
        "message": "User delete successful"
    }
}
1.5 Get User List
Endpoint: GET /users/list

Response:

{
    "resultCode": "A200",
    "resultMessage": "Success",
    "resultData": {
        "content": [
            {
                "username": "acro1@acrofuture.com",
                "nickName": "aa",
                "gender": "female",
                "isActive": true,
                "type": "back",
                "description": "this is description1"
            }
        ],
        "pageInfo": {
                "pageNumber": 1,
                "pageSize": 10,
                "totalElements": 32,
                "totalPages": 4
            }
        }
    }
2. Authentication Management
2.1 Admin Signup
Endpoint: POST /auth/signup

Request Body:

{
    "email": "acro_admin1@acrofuture.com",
    "name": "acro",
    "password": "password123",
    "password_confirm": "password123"
}
Response (Success):

{
    "resultCode": "A201",
    "resultMessage": "Success",
    "resultData": {
        "message": "User successfully created"
    }
}
Response (Bad Request): <이미있는 이메일로 사용자 생성 시>

{
    "resultCode": "A400",
    "resultMessage": "Bad Request",
    "resultData": {
        "message": "Email already exists"
    }
}
Response (Bad Request): <잘못된 이메일 형식 시>

{
    "resultCode": "A400",
    "resultMessage": "Bad Request",
    "resultData": {
        "message": "Invalid email format"
    }
}
Response (Bad Request): <필수 필드 누락>

{
    "resultCode": "A400",
    "resultMessage": "Bad Request",
    "resultData": {
        "message": "Missing required fields"
    }
}
Response (Bad Request): <사용자 생성 실패>

{
    "resultCode": "A400",
    "resultMessage": "Bad Request",
    "resultData": {
        "message": "Failed to create user"
    }
}
Response (Internal Server Error): <서버 에러 (예: 데이터베이스 오류)>

{
    "resultCode": "A500",
    "resultMessage": "Internal Server Error",
    "resultData": {
        "message": "Failed to create user due to server error"
    }
}
2.2 Admin Login
Endpoint: POST /auth/login

Request Body:

{
    "email": "acro1@acrofuture.com",
    "name": "acro1",
    "password": "password123"
}
Response (Success):

{
    "resultCode": "A200",
    "resultMessage": "Success",
    "resultData": {
        "message": "Login successful",
        "token": "jwt_token_here"
        "user": {
            "email": "acro1@acrofuture.com",
            "name": "acro1",
            "password": "password123"
        }
    }
}
Response (Unauthorized): <잘못된 이메일 또는 비밀번호>

{
    "resultCode": "A401",
    "resultMessage": "Unauthorized",
    "resultData": {
        "message": "Invalid email or password"
    }
}
Response (Unauthorized): <이메일이 존재하지 않음>

{
    "resultCode": "A401",
    "resultMessage": "Not Found",
    "resultData": {
        "message": "Email not found"
    }
}
Response (Unauthorized): <비밀번호가 틀림>

{
    "resultCode": "A401",
    "resultMessage": "Unauthorized",
    "resultData": {
        "message": "Incorrect password"
    }
}
Response (Unauthorized): <토큰 만료>

{
    "resultCode": "A401",
    "resultMessage": "Unauthorized",
    "resultData": {
        "message": "Token has expired"
    }
}
Response (Internal Server Error): <서버 에러>

{
    "resultCode": "A500",
    "resultMessage": "Internal Server Error",
    "resultData": {
        "message": "Login failed due to server error"
    }
}
2.3 Admin Logout
Endpoint: POST /auth/logout

Request Header:

Authorization: Bearer { jwt_token }
Response (Success):

{
    "resultCode": "A200",
    "resultMessage": "Success",
    "resultData": {
        "message": "Logout successful"
    }
}
Response (Bad Request): <로그아웃 실패 (토큰이 없음)>

{
    "resultCode": "A400",
    "resultMessage": "Bad Request",
    "resultData": {
        "message": "No token provided"
    }
}
[DB]
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(255) UNIQUE NOT NULL,
    nick_name VARCHAR(255) NOT NULL,
    gender VARCHAR(10) CHECK (gender IN ('male', 'female')),
    is_active BOOLEAN DEFAULT TRUE,
    type VARCHAR(50) CHECK (type IN ('back', 'front', 'dba', 'infra')),
    password VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    deleted_at TIMESTAMP
);
CREATE TABLE admins (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(255) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    deleted_at TIMESTAMP
);
CREATE TABLE auth_tokens (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    token TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
