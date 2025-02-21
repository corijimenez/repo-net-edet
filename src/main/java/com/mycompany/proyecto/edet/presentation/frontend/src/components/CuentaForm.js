import React, { useState } from "react";
import { registerAccount } from "../services/api"; // Importamos la función para interactuar con la API

const CuentaForm = ({ onSuccess }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [acceptTerms, setAcceptTerms] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (password !== confirmPassword) {
      setErrorMessage("Las contraseñas no coinciden");
      return;
    }

    if (!acceptTerms) {
      setErrorMessage("Debes aceptar los términos y condiciones");
      return;
    }

    // Llamar a la API para registrar la cuenta
    try {
      await registerAccount({ email, password, confirmPassword, acceptTerms });
      onSuccess(); // Pasamos el control al siguiente paso si la cuenta fue creada con éxito
    } catch (error) {
      setErrorMessage(error.message || "Hubo un error al registrar la cuenta");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Crear Cuenta</h2>
      <div>
        <label>Email</label>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Contraseña</label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Confirmar Contraseña</label>
        <input
          type="password"
          value={confirmPassword}
          onChange={(e) => setConfirmPassword(e.target.value)}
          required
        />
      </div>
      <div>
        <label>
          <input
            type="checkbox"
            checked={acceptTerms}
            onChange={(e) => setAcceptTerms(e.target.checked)}
          />
          Acepto los términos y condiciones
        </label>
      </div>
      {errorMessage && <p>{errorMessage}</p>}
      <button type="submit">Registrar</button>
    </form>
  );
};

export default CuentaForm;
