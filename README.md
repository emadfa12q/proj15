# WorkTimeTracker Android v12 - Sahel Fonts Ready

این نسخه برای استفاده از خانواده فونت Sahel آماده شده است.

## فایل‌های فونت مورد انتظار
برای فعال شدن فونت‌ها، پنج فایل زیر را در مسیر زیر قرار بده:

```text
app/src/main/assets/fonts/
```

نام فایل‌ها باید دقیقاً این‌ها باشد:

```text
Sahel-FD-WOL.ttf
Sahel-Light-FD-WOL.ttf
Sahel-SemiBold-FD-WOL.ttf
Sahel-Bold-FD-WOL.ttf
Sahel-Black-FD-WOL.ttf
```

## وزن‌های استفاده‌شده
- متن معمولی: `Sahel-FD-WOL.ttf`
- متن کم‌اهمیت و توضیحات: `Sahel-Light-FD-WOL.ttf`
- دکمه‌ها و چیپ‌ها: `Sahel-SemiBold-FD-WOL.ttf`
- تیترها: `Sahel-Bold-FD-WOL.ttf`
- اعداد بزرگ و عنوان‌های اصلی: `Sahel-Black-FD-WOL.ttf`

## نکته مهم
کد برنامه فقط برای همین فونت‌ها تنظیم شده است. اگر فایل‌ها در مسیر بالا نباشند، برنامه برای جلوگیری از crash با فونت پیش‌فرض اندروید اجرا می‌شود؛ اما برای خروجی نهایی باید حتماً فایل‌های فونت را در مسیر گفته‌شده بگذاری.

## ساخت APK
فایل‌ها را مستقیم در ریشه repository قرار بده و workflow آماده داخل `.github/workflows/main.yml` را اجرا کن.
