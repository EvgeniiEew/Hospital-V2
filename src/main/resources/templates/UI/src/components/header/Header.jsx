import React from "react";
import s from "./Header.module.css";
const Header = (props) => {
  return (
    <header className={s.header}>
      <div className={s.nav}>
        <div>На главную </div>
        <div>Врачи </div>
      </div>
      <div className={s.auth}>
        <div>RUS</div>
        <div>EN</div>
        <div>
          <button>войти</button>
        </div>
        <div>
          <button>регистрация</button>
        </div>
      </div>
    </header>
  );
};

export default Header;
