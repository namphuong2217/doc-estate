# DocEstate tasks

##### 
[app-react repository](https://github.com/namphuong2217/doc-estate-react)

# Overview

### Aufgabe 1 Testing API

* Query All Users

![Query All Users](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/1GetAllUsers.png)

* Add a new user 

![Query User](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/2PostNewUserSuccess.png)


* Add a new user failed

![Query User](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/2PostNewUserFail.png)

* Add a new user  Failed

![Query User](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/3PostNewUserFail.png)


* Query A User by Id 

![Query User](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/4GetUserSuccess.png)


* Query A User by Id Failed

![Query User](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/5GetUserFail.png)


* Delete a user 

![Register User](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/6DeleteUserSuccess.png)


* Delete a user failed

![Register User](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/5GetUserFail.png)


### Aufgabe 2 React UI


* Query All Users

![Query All Users](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/8ReactGetAllUsers.png)


* Query A User by Id | ``Back To All Users`` button displays all users

![Query User](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/9ReactGetUserSuccess.png)


* Query A User by Id Failed

![Query User](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/9ReactGetUserFail.png)

* Delete a user with ``Delete User`` Button

![Register User](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/10ReactDeleteUser.png)


* Register new user | ``List All Users`` button displays all users

![Query All Users](https://github.com/namphuong2217/doc-estate/blob/main/Documentation/111ReactFrontendRegister.png)


### Aufgabe 3 Spring Security

Spring Security Configuration

[``WebSecurityConfig``](https://github.com/namphuong2217/doc-estate/blob/main/src/main/java/com/nam/demo/config/WebSecurityConfig.java)

UserDetails Class wrap around User model required by Spring Security 

[``CustomUserDetails.``](https://github.com/namphuong2217/doc-estate/blob/main/src/main/java/com/nam/demo/security/CustomUserDetails.java)

CustomUserDetailsService Class manages UserDetails Class required by Spring Security 

[``CustomUserDetailsService``](https://github.com/namphuong2217/doc-estate/blob/main/src/main/java/com/nam/demo/security/CustomUserDetailsService.java)

JwtAuthenticationFilter: Custom filter for authentication in Spring Security 

[``JwtAuthenticationFilter``](https://github.com/namphuong2217/doc-estate/blob/main/src/main/java/com/nam/demo/security/JwtAuthenticationFilter.java)

JwtProvider: JSON Web Token for authentication in Spring Security 

[``JwtProvider``](https://github.com/namphuong2217/doc-estate/blob/main/src/main/java/com/nam/demo/security/JwtProvider.java)









