<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Rendez-vous Medecin</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex flex-col items-center min-h-screen p-6 text-white bg-cover bg-center bg-no-repeat bg-opacity-50"
      style="background-image: url('https://images.pexels.com/photos/6129042/pexels-photo-6129042.jpeg?auto=compress&cs=tinysrgb&h=1080&w=1920');">

<!-- Bouton Retour en haut à droite -->
<a href="index.jsp" class="fixed top-6 right-6 bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded-md">
  Retour à l'Accueil
</a>

<h2>Mes rendez-vous</h2>

<div class="bg-white bg-opacity-20 p-6 rounded-lg shadow-lg w-full max-w mb-6">
  <h3 class="text-lg font-bold mb-4 ">Rendez-vous :</h3>
  <table class="w-full table-auto">
    <thead>
    <tr>
      <th class="text-black px-4 py-2 text-left">Nom d'utilisateur</th>
      <th class="text-black px-4 py-2 text-left">Motif</th>
      <th class="text-black px-4 py-2 text-left">Date</th>
      <th class="text-black px-4 py-2 text-left">Heure</th>
      <th class="text-black px-4 py-2 text-left">Actions</th>
    </tr>
    </thead>
    <tbody>

    <tr>
      <td class="text-black px-4 py-2">John Doe</td>
      <td class="text-black px-4 py-2">Consultation générale</td>
      <td class="text-black px-4 py-2">2025-02-20</td>
      <td class="text-black px-4 py-2">14:00</td>
      <td class="px-4 py-2">
        <div class="flex space-x-2">
          <form action="/confirmerRendezvous" method="post" class="inline">
            <input type="hidden" name="idRendezvous" value="1">
            <button type="submit" class="bg-green-500 hover:bg-green-600 text-white py-1 px-3 rounded-md">Confirmer</button>
          </form>

          <form action="/annulerRendezvous" method="post" class="inline">
            <input type="hidden" name="idRendezvous" value="1">
            <button type="submit" class="bg-red-500 hover:bg-red-600 text-white py-1 px-3 rounded-md">Annuler</button>
          </form>

          <form action="/reporterRendezvous" method="post" class="inline">
            <input type="hidden" name="idRendezvous" value="1">
            <button type="submit" class="bg-yellow-500 hover:bg-yellow-600 text-white py-1 px-3 rounded-md">Reporter</button>
          </form>
        </div>
      </td>
    </tr>

    <tr>
      <td class="text-black px-4 py-2">Jane Smith</td>
      <td class="text-black px-4 py-2">Vaccination</td>
      <td class="text-black px-4 py-2">2025-02-21</td>
      <td class="text-black px-4 py-2">10:30</td>
      <td class="text-black px-4 py-2">
        <div class="flex space-x-2">
          <form action="/confirmerRendezvous" method="post" class="inline">
            <input type="hidden" name="idRendezvous" value="2">
            <button type="submit" class="bg-green-500 hover:bg-green-600 text-white py-1 px-3 rounded-md">Confirmer</button>
          </form>

          <form action="/annulerRendezvous" method="post" class="inline">
            <input type="hidden" name="idRendezvous" value="2">
            <button type="submit" class="bg-red-500 hover:bg-red-600 text-white py-1 px-3 rounded-md">Annuler</button>
          </form>

          <form action="/reporterRendezvous" method="post" class="inline">
            <input type="hidden" name="idRendezvous" value="2">
            <button type="submit" class="bg-yellow-500 hover:bg-yellow-600 text-white py-1 px-3 rounded-md">Reporter</button>
          </form>
        </div>
      </td>
    </tr>

    </tbody>
  </table>
</div>

</body>
</html>
