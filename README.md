# TWICE 멤버 사진 앱

이 프로젝트는 안드로이드 스튜디오(Android Studio)로 개발한 TWICE 멤버 사진 갤러리 앱입니다.  
앱의 주요 기능과 구현 과정에서 배운 개념을 정리합니다.

---

## 주요 화면

- **스플래시 화면**  
  앱 실행 시 로고 또는 이미지를 잠깐 보여줍니다.  
  ![스플래시](https://github.com/user-attachments/assets/c8a388da-910b-4c09-aff8-aaf1324c6cb1)


- **메인 화면**  
  9명의 멤버 사진이 CardView로 동그랗게 배치되어 있습니다.  
  ![트와이스_메인](https://github.com/user-attachments/assets/c2f52592-863e-4f7e-a8b6-f9234d6d396a)


- **상세 화면**  
  멤버 사진을 클릭하면 해당 이미지를 크게 볼 수 있습니다.  
  ![사진클릭했을때](https://github.com/user-attachments/assets/5ce13826-05b5-4709-a581-e7e205c2c4ba)


---

## 구현 및 학습 내용

### 1. 스플래시 화면(Splash Screen)

- 앱 시작 시 3초 동안 이미지를 보여준 뒤 메인 화면으로 이동합니다.
- Handler를 사용해 일정 시간 후 화면 전환을 구현했습니다.
- **스플래시 화면의 목적:**  
  앱이 준비되는 동안 로고나 브랜드 이미지를 보여주어 사용자가 앱이 정상적으로 실행되고 있음을 인식할 수 있게 합니다.
```kotlin
Handler().postDelayed({
  startActivity(Intent(this, MainActivity::class.java))
  finish()
}, 3000)
```

---

### 2. margin과 padding

- **margin:** View(예: CardView) 바깥쪽 여백.  
  멤버 사진 사이의 간격을 주기 위해 CardView에 `android:layout_margin="10dp"`를 적용했습니다.
- **padding:** View 안쪽 여백을 의미하며, 이 프로젝트에서는 주로 margin을 사용했습니다.

---

### 3. Intent로 데이터 전달

- 각 멤버 이미지를 클릭하면, `Intent`의 `putExtra()`를 이용해 데이터(멤버 번호)를 상세 화면으로 전달합니다.
- 상세 화면에서는 전달받은 데이터를 바탕으로 해당 멤버의 이미지를 보여줍니다.

```kotlin
val intent = Intent(this, ImageInsideActivity::class.java)
intent.putExtra("data", "1")
startActivity(intent)
```

---

### 4. ImageView의 scaleType

- 처음에는 `android:scaleType="center"`를 사용했으나, 이미지가 View를 꽉 채우지 않아 `fitXY`로 변경했습니다.
- **center:** 이미지를 원본 크기로 중앙에 배치 (빈 공간이 생길 수 있음)
- **fitXY:** 이미지를 View 영역에 꽉 채움 (비율이 깨질 수 있음)

---

### 5. CardView로 사진을 동그랗게 만들기

- 각 멤버 이미지는 CardView로 감싸고, `app:cardCornerRadius="50dp"` 속성을 이용해 모서리를 둥글게 만들었습니다.
- CardView를 사용하기 위해서는 **의존성 추가가 필수**입니다.

```kotlin
implementation("androidx.cardview:cardview:1.0.0")
```

---

### 6. 주요 레이아웃 구조

- LinearLayout과 CardView를 조합해 멤버 사진을 3x3 형태로 배치했습니다.
- 각 ImageView는 CardView로 감싸서 둥근 테두리가 적용됩니다.

```
<androidx.cardview.widget.CardView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    app:cardCornerRadius="50dp">

<ImageView
    android:id="@+id/member1"
    android:scaleType="fitXY"
    android:src="@drawable/member_1"
    android:layout_width="120dp"
    android:layout_height="150dp"/>

```

# References
[왕초보편] 앱 8개를 만들면서 배우는 안드로이드 코틀린(Android Kotlin)
https://www.inflearn.com/course/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%BD%94%ED%8B%80%EB%A6%B0-%EB%AA%A8%EB%B0%94%EC%9D%BC%EC%95%B1
