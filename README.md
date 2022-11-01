__<h1 align="center">PROJECT NAME : BOMBERMAN GAME!</h3>__
__<h1 align="center">WELCOME TO OUR PROJECT! LETS START! AND HAVING FUN!</h1>__
[DEMO GAME & SUBSCRIBE PLEASE!](https://youtu.be/TRRgNQzixkM)

__I. [English version](#English-version)__

 Whats new:
1. [Introduction](#Introduction)
2. [Contributors](#Contributors)
3. [Installation](#Installation)
4. [UML Class Diagram](#UML-Class-Diagram)
5. [Features](#Features)
6. [How to play Bomberman](#How-to-play-Bomberman)
7. [Final](#Final)
8. [Supporters](#Supporters)


__II. [Vietnamese version](#Vietnamese-version)__

 Thông tin gồm có:
1. [Giới thiệu](#Giới-thiệu)
2. [Thành viên](#Thành-viên)
3. [Cài đặt trò chơi](#Cài-đặt-trò-chơi)
4. [UML Class Diagram](#UML-Class-Diagram)
5. [Đặc điểm](#Đặc-điểm)
6. [Cách chơi](#Cách-chơi)
7. [Tổng kết](#Tổng-kết)
8. [Hỗ trợ](#Hỗ-trợ)

# I. ENGLISH VERSION <a name="English-version"></a>  

## 1. Introduction <a name="Introduction"></a>
### [From Wikipedia](https://en.wikipedia.org/wiki/Bomberman)

Bomberman (ボンバーマン, Bonbāman, also briefly known as Dyna Blaster in Europe) is a video game franchise originally developed by Hudson Soft and currently owned by Konami. The original game, also known as Bakudan Otoko (爆弾男), was released in Japan in July 1983 and has since spawned multiple sequels and spin-offs released on numerous platforms, as well as several anime and manga adaptations.

### Reason for made the game:

This is our game project for our required final lab in our Object-Oriented Programming course in semester 1 year 2022 - 2023. Bomberman is an individual game that does not require players have good skills or advanced technology. It's a game that may be enjoyed by most of people.
<h2 align="center">THANK YOU!</h2>

## 2. Contributors <a name="Contributors"></a> 

| Order |         Name          |     ID      |            Email            |                       Github account                        |   
| :---: | :-------------------: | :---------: | :-------------------------: | :---------------------------------------------------------: | 
|   1   | Nguyen Ngoc Cuong  | 21020285 | 21020285@vnu.edu.vn |  [21020285](https://github.com/21020285)      |
|   2   | Pham Tuan Dat      | 19020517 | 19020517@vnu.edu.vn |  [PhamTuanDat-19020517](https://github.com/PhamTuanDat-19020517)      | 
|   3   | Tran Vu Toan | 19020637 | toantink261412@gmail.com | [tvtitk64](https://github.com/tvtitk64)        |   
## 3. Installation <a name="Installation"></a>

1. Open the terminal on your IDE

2. Clone the repo
   ```sh
   git clone https://github.com/PhamTuanDat-19020517/Bomberman
   ```
3. Check the file status
   ```sh
   git status
   ```
4. Change branch
   ```js
   git checkout 'branch_name'
   ```
   
## 4. UML Class Diagram <a name="UML-Class-Diagram"></a>:clipboard:
a. Move button
- [Function & Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/keyHandle.png)

b. Graphic 
- [Function](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/BombermanGame(function).png)
- [Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/graphics(method).png)

c. Audio 
- [Function & Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/audio.png)

d. Object
* [Enemy(Not count AI)](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/enemy.png)
* [Not moving object](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/NotMovingObject.png)
* [Player](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/Player.png)
* [Tile](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/title.png)
* [Bomb & Explosion](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/explosion.png)
* [AI](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/AIMode.png)

e. Item
- [Function & Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/item.png)

f. Gamerunner
- [Function](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/BombermanGame(function).png)
- [Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/BombermanGame(method).png)

g. Collision
- [Function & Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/CollisionChecker.png)

h. Level & Map 
- [Function & Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/level.png)

## 5. Features <a name="Features"></a>
- Language: [JAVA](https://www.java.com/en/)
- IDE: [IntelliJ](https://www.jetbrains.com/idea/)
- Intelligent: Some basic.
- Library: [JavaFx](https://openjfx.io)

## 6. How to play Bomberman <a name="How-to-play-Bomberman"></a>

Players will direct the character's movement in order to place bombs to killing the enemy. After the player has killed all of the monsters of this level a portal will open for the character to enter in order to advance to the next level.
Ofc we have 3 levels. You will direct the character's movement by 4 buttom in the key is left, right, up, down. 
You have maxinum 200 seconds to pass each level. Good luck!

Whats new in game:

- Character: The character is controlled by the arrow key combination, only one bomb can be placed at a time. But don't worry! There is some items can help you, here:
<div align="center">
<img src="res/sprites/powerup_bombpass.png" alt="">
<img src="res/sprites/powerup_bombs.png" alt="">
<img src="res/sprites/powerup_detonator.png" alt="">
<img src="res/sprites/powerup_flamepass.png" alt="">
<img src="res/sprites/powerup_speed.png" alt="">
<img src="res/sprites/powerup_wallpass.png" alt=""> 
</div>
They are: Can pass bomb, increase bomb can place as same time, increase bomb area explose, can pass flame without lose a live, faster, can pass wall.

- Enemy : Includes 5 types and is divided by level, each type has its own attribute. You should try some times and know what is their features!
<div align="center">
<img src="res/sprites/balloom_left1.png" alt="">
<img src="res/sprites/doll_left1.png" alt="">
<img src="res/sprites/kondoria_left1.png" alt="">
<img src="res/sprites/minvo_left1.png" alt="">
<img src="res/sprites/oneal_left1.png" alt=""> 
</div>

- Brick : It can be broken by bombs and can contain items

- Wall : It can't be broken to limit the movement of characters and enemies

## 7. Final <a name="Final"></a>

<div style="text-align:justify">
This is the first time we make a group project game like Bomberman, although it is made by many people before. Hope everyone having fun and enjoy the gaame! If bugs happen, we apologize for our limit experience and didn't check for that! Also, hope everyone can support us for open game more functions!
Thank you!
</div> 

## 8. Supporters <a name="Supporters"></a>
### Teacher: Nguyen Duc Anh, Email: [nguyenducanh@vnu.edu.vn](nguyenducanh@vnu.edu.vn)
### Lecturer: Ngo Kien Tuan, Email: [tuanngokien@vnu.edu.vn](tuanngokien@vnu.edu.vn)


# II. VIETNAMESE VERSION <a name="Vietnamese-version"></a>

## 1. Giới thiệu <a name="Giới-thiệu"></a>
### [Trích dẫn từ Wikipedia](https://vi.wikipedia.org/wiki/Bomberman_(tr%C3%B2_ch%C6%A1i_%C4%91i%E1%BB%87n_t%E1%BB%AD_1983))

Bomberman (ボンバーマン Bonbāman?) (ボンバーマン Bonbāman?) là một trò chơi điện tử dạng mê cung theo phong cách game thùng do Hudson Soft phát triển. Trò chơi máy tính gia đình đầu tiên là Bomber Man (爆 弾 男, Bakudan Otoko) phát hành vào tháng 7 năm 1983 cho NEC PC-8801, NEC PC-6001 mkII, Fujitsu FM-7, Sharp MZ-700, Sharp MZ-2000, Sharp X1 và MSX ở Nhật Bản, phiên bản chỉnh sửa đồ họa cho MSX và ZX Spectrum ở châu Âu có tên gọi Eric and the Floaters.[2][3] Phần tiếp theo tại Nhật Bản gọi là 3-D Bomberman, Bomberman đi trong mê cung theo góc nhìn thứ nhất. Năm 1985, Bomberman phát hành trên Nintendo Entertainment System. Tựa trò chơi này đã khai sinh ra loạt Bomberman với rất nhiều phần được xây dựng dựa trên lối chơi cơ bản của nó.

### Lý do nhóm mình làm game này

Đây là 1 trò chơi phục vụ cho bài dự án cuối kỳ của môn Lập trình hướng đối tượng (OOP) của kỳ 1 năm 2022 - 2023. Đây là 1 trò chơi cá nhân và không kén chọn người chơi khi không cần kĩ năng cao với trình hiểu biết công nghệ không quá sâu rộng!
Hi vọng mọi người thích nó!
<h3 align="center">CẢM ƠN!</h3>

## 2. Thành viên <a name="Thành-viên"></a>
| STT |         Tên          |  Mã sinh viên  |            Email            |                      Tài khoản Github                        |   
| :---: | :-------------------: | :---------: | :-------------------------: | :---------------------------------------------------------: | 
|   1   | Nguyễn Ngọc Cường  | 21020285 | 21020285@vnu.edu.vn |  [21020285](https://github.com/21020285)      |
|   2   | Phạm Tuấn Đạt      | 19020517 | 19020517@vnu.edu.vn |  [PhamTuanDat-19020517](https://github.com/PhamTuanDat-19020517)      | 
|   3   | Trần Vũ Toàn | 19020637 | toantink261412@gmail.com | [tvtitk64](https://github.com/tvtitk64)        |   

## 3. Cài đặt trò chơi <a name="Cài-đặt-trò-chơi"></a>
Không biết cách vietsub hướng dẫn như thế nào :)) Mong mọi người thông cảm!
1. Open the terminal on your IDE

2. Clone the repo
   ```sh
   git clone https://github.com/PhamTuanDat-19020517/Bomberman
   ```
3. Check the file status
   ```sh
   git status
   ```
4. Change branch
   ```js
   git checkout 'branch_name'
   ```
## 4. UML Class Diagram (Không nghĩ ra từ để vietsub) <a name="UML-Class-Diagram"></a>:clipboard:
Vẫn không biết cách vietsub Function & Method sao cho hợp lý!

a. Nút di chuyển
- [Function & Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/keyHandle.png)

b. Đồ họa 
- [Function](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/BombermanGame(function).png)
- [Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/graphics(method).png)

c. Âm thanh 
- [Function & Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/audio.png)

d. Vật thê
* [Enemy(Not count AI)](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/enemy.png)
* [Not moving object](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/NotMovingObject.png)
* [Player](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/Player.png)
* [Tile](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/title.png)
* [Bomb & Explosion](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/explosion.png)
* [AI](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/AIMode.png)

e. Trang bị 
- [Function & Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/item.png)

f. Chạy trò chơi
- [Function](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/BombermanGame(function).png)
- [Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/BombermanGame(method).png)

g. Va chạm
- [Function & Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/CollisionChecker.png)

h. Cấp độ & Bản đồ trò chơi
- [Function & Method](https://github.com/PhamTuanDat-19020517/Bomberman/blob/master/UML%20class%20image/level.png)

## 5. Đặc điểm <a name="Đặc-điểm"></a>
- Ngôn ngữ: [JAVA](https://www.java.com/en/)
- IDE: [IntelliJ](https://www.jetbrains.com/idea/)
- Thuật toán: 1 số cơ bản
- Thư viện: [JavaFx](https://openjfx.io)

## 6. Cách chơi <a name="Cách-chơi"></a>
- Nhân vật: Điều khiển bằng 4 nút mũi tên di chuyển, chỉ đặt được bom 1 lần 1 lúc. Nhưng đừng lo, có các vật phẩm sẽ hỗ trợ bạn!
<div align="center">
<img src="res/sprites/powerup_bombpass.png" alt="">
<img src="res/sprites/powerup_bombs.png" alt="">
<img src="res/sprites/powerup_detonator.png" alt="">
<img src="res/sprites/powerup_flamepass.png" alt="">
<img src="res/sprites/powerup_speed.png" alt="">
<img src="res/sprites/powerup_wallpass.png" alt=""> 
</div>
Những trợ giúp gồm: Đi xuyên qua bom, tăng số lượt đặt bom cùng 1 lúc, tăng hỏa lực bom, bị bom nổ mà không chết, tăng tốc, đi xuyên tường.

- Quái vật : Gồm 5 loại, được chia theo độ khó và mỗi loại có 1 đặc điểm riêng. Bạn nên thử vài lần để biết các quái vật có đặc điểm gì!
<div align="center">
<img src="res/sprites/balloom_left1.png" alt="">
<img src="res/sprites/doll_left1.png" alt="">
<img src="res/sprites/kondoria_left1.png" alt="">
<img src="res/sprites/minvo_left1.png" alt="">
<img src="res/sprites/oneal_left1.png" alt=""> 
</div>

- Gạch : Có thể bị phá bởi bom và 1 số vật phẩm

- Tường : Không thể bị phá, vật cản trở cả người chơi lẫn quái vật

## 7. Tổng kết <a name="Tổng-kết"></a>

<div style="text-align:justify">
Đây là lần đầu bọn mình làm 1 dự án nhóm trò chơi Bomberman, mặc dù trước đó đã có người làm ra. Hi vọng mọi người thưởng thức nó! Nếu có lỗi xảy ra, mong các bạn bỏ qua cho bọn mình bởi sự thiếu kinh nghiệm của bọn mình khi chưa tìm và sửa được nó! Hơn nữa, mong mọi người ủng hộ để bọn mình có thể ra thêm chức năng khác của game!
Cảm ơn mọi người đã xem!
</div> 

## 8. Hỗ trợ <a name="Hỗ-trợ"></a>
### Giảng viên lý thuyết: thầy Nguyễn Đức Anh, Email: [nguyenducanh@vnu.edu.vn](nguyenducanh@vnu.edu.vn)
### Giảng viên thực hành: thầy Ngô Kiên Tuấn, Email: [tuanngokien@vnu.edu.vn](tuanngokien@vnu.edu.vn)
