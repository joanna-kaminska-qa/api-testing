const nodemailer = require("nodemailer");


const transporter = nodemailer.createTransport({
  host: "127.0.0.1",
  port: 1025,
  secure: false 
});


(async () => {
  try {
    const info = await transporter.sendMail({
      from: '"Joanna Kaminska" <jk@example.com>',
      to: "bar@example.com, baz@example.com",
      subject: "Testowy tytuł wiadomości",
      text: "Przykładowy tekst",
      html: "<h2>Nagłówek h2</h2><br /> <p style='color: red'>Przykładowy paragraf</p>",
    });
    console.log("Wiadomość wysłana: %s", info.messageId);
  } catch (err) {
    console.error("Błąd przy wysyłaniu maila:", err);
  }
})();