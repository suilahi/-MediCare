<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DoctorRV - Accueil</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex flex-col items-center min-h-screen p-6 text-white bg-cover bg-center bg-no-repeat"
      style="background-image: url('https://images.pexels.com/photos/6129042/pexels-photo-6129042.jpeg?auto=compress&cs=tinysrgb&h=1080&w=1920');">

<h2 class="text-3xl font-bold mb-6">Bienvenue sur DoctorRV</h2>

<div class="bg-white bg-opacity-20 p-6 rounded-lg shadow-lg w-full max-w-md mb-6">
    <h3 class="text-xl font-semibold mb-4">Réserver un rendez-vous</h3>
    <p>Réservez votre prochain rendez-vous médical en quelques clics.</p>
    <a href="Patient.jsp"
       class="w-full bg-red-500 hover:bg-red-600 text-white font-bold py-2 rounded-md text-center block mt-4">
        Prendre un rendez-vous
    </a>
</div>

<div class="bg-white bg-opacity-20 p-6 rounded-lg shadow-lg w-full max-w-md">
    <h3 class="text-xl font-semibold mb-4">Consulter vos rendez-vous</h3>
    <p>Vérifiez, confirmez, annulez ou reportez vos rendez-vous médicaux.</p>
    <a href="Medecin.jsp"
       class="w-full bg-green-500 hover:bg-green-600 text-white font-bold py-2 rounded-md text-center block mt-4">
        Consulter mes rendez-vous
    </a>
</div>
</body>
</html>
