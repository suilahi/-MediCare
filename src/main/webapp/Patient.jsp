<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DoctorRV - Réservation de Rendez-Vous Médicaux</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex flex-col items-center min-h-screen p-6 text-white bg-cover bg-center bg-no-repeat"
      style="background-image: url('https://images.pexels.com/photos/6129042/pexels-photo-6129042.jpeg?auto=compress&cs=tinysrgb&h=1080&w=1920');">

<h2 class="text-3xl font-bold mb-6">Bienvenue sur DoctorRV</h2>

<div class="bg-white bg-opacity-20 p-6 rounded-lg shadow-lg w-full max-w-md">
    <h3 class="text-xl font-semibold mb-4">Prendre un rendez-vous</h3>
    <form action="ReservationServlet" method="post" class="space-y-4">
        <div>
            <label for="username" class="block font-medium">Nom d'utilisateur :</label>
            <input type="text" id="username" name="username" required
                   class="w-full p-2 rounded-md border-none focus:ring-2 focus:ring-blue-300 text-gray-900">
        </div>

        <div>
            <label for="email" class="block font-medium">Email :</label>
            <input type="email" id="email" name="email" required
                   class="w-full p-2 rounded-md border-none focus:ring-2 focus:ring-blue-300 text-gray-900">
        </div>

        <div>
            <label for="telephone" class="block font-medium">Téléphone :</label>
            <input type="text" id="telephone" name="telephone" required
                   class="w-full p-2 rounded-md border-none focus:ring-2 focus:ring-blue-300 text-gray-900">
        </div>

        <div>
            <label for="motif" class="block font-medium">Motif :</label>
            <textarea id="motif" name="motif" required
                      class="w-full p-2 rounded-md border-none focus:ring-2 focus:ring-blue-300 text-gray-900"></textarea>
        </div>

        <div>
            <label for="date" class="block font-medium">Date :</label>
            <input type="date" id="date" name="date" required
                   class="w-full p-2 rounded-md border-none focus:ring-2 focus:ring-blue-300 text-gray-900">
        </div>

        <div>
            <label for="heure" class="block font-medium">Heure :</label>
            <input type="time" id="heure" name="heure" required
                   class="w-full p-2 rounded-md border-none focus:ring-2 focus:ring-blue-300 text-gray-900">
        </div>

        <button type="submit"
                class="w-full bg-red-500 hover:bg-red-600 text-white font-bold py-2 rounded-md transition duration-300">
            Réserver
        </button>
    </form>
</div>

<div class="bg-white bg-opacity-20 p-6 rounded-lg shadow-lg w-full max-w-md mt-6">
    <h3 class="text-xl font-semibold mb-4">Consulter mes rendez-vous</h3>
    <form action="ConsultationServlet" method="get" class="space-y-4">
        <div>
            <label for="search_username" class="block font-medium">Nom d'utilisateur :</label>
            <input type="text" id="search_username" name="username" required
                   class="w-full p-2 rounded-md border-none focus:ring-2 focus:ring-blue-300 text-gray-900">
        </div>
        <button type="submit"
                class="w-full bg-green-500 hover:bg-green-600 text-white font-bold py-2 rounded-md transition duration-300">
            Consulter
        </button>
    </form>
</div>
</body>

</html>
