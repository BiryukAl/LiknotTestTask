# LiknotTestTask

## Выполнил:

* Бирюков Александр
* Tg: https://t.me/SanyaLn
* Время выполнения 4.5 чваса, больше времени потрачена на архитектуру приложения, посмотреть можно по комитам 

Тестовое задание

Задача: Разработать приложение с функциональностью загрузки веб-сайта в вебвью и отображения
перехваченных параметров id и uuid.

При нажатии на кнопку "Загрузить", веб-сайт должен быть загружен в вебвью, исходная
ссылка ' http://app.zaimforyou.ru/hello ' на сайт должна быть зашита в приложении.
В процессе загрузки веб-сайта, на экране должен отображаться ProgressBar.
В процессе загрузки веб-сайта необходимо отловить все редиректы и проверить, содержат ли они GET
параметры id и uuid.
После последнего редиректа, следует скрыть ProgressBar и кнопку "Загрузить".
После окончания загрузки, необходимо показать вебвью с загруженным веб-сайтом.
Под вебвью должен быть размещен TextView, в котором будут отображены значения параметров id и uuid,
если они были пойманы во время загрузки.
Значения параметров id и uuid, полученные в прошлой сессии работы приложения, должны быть сохранены
и отображены повторно при следующем запуске приложения.

Общие указания:
Отображение ProgressBar позволяет пользователю видеть процесс загрузки страницы.
По окончанию загрузки следует скрыть ProgressBar и кнопку "Загрузить", чтобы не мешать просмотру
страницы.
Сохранение параметров id и uuid реализовать с любым штатным
способом (https://developer.android.com/training/data-storage)

### Выполнение

Cсылка редиректит поочередно на другие страницы :

* http://app.zaimforyou.ru/hello/welcome
* http://app.zaimforyou.ru/hello/hidden
* http://app.zaimforyou.ru/hello/go-out?id=31203768&uuid=OV3LRbTFVBREMJ88irEIiBFBYh7z2Dqd
* https://google.com/
* https://www.google.com/

Для того чтобы отловить id нужно было переопределить у WebViewClient функцию
shouldOverrideUrlLoading
и проверять уже там сожержит ссылка на которую перенаправила содержит нужные хэдоры.
И уже при последней зугрузки эти параметры сохранять

Сохранение: Использовал SharedPreferences, считал не рациональным подключать бд

Стэйт экрана поддерживается
