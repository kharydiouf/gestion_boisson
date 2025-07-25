<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion - Gestion des Boissons</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">
<div class="bg-white p-8 rounded-lg shadow-lg w-full max-w-md">
    <h1 class="text-2xl font-bold text-center mb-6">Connexion</h1>
    <c:if test="${not empty error}">
        <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-2 rounded mb-4 text-center">
                ${error}
        </div>
    </c:if>
    <form action="utilisateurs" method="post" class="space-y-4">
        <input type="hidden" name="action" value="login">
        <div>
            <label for="email" class="block text-sm font-medium text-gray-700">Email</label>
            <input type="email" id="email" name="email" class="mt-1 block w-full border-gray-300 rounded-md shadow-sm p-2 focus:ring-indigo-500 focus:border-indigo-500" required>
        </div>
        <div>
            <label for="motDePasse" class="block text-sm font-medium text-gray-700">Mot de passe</label>
            <input type="password" id="motDePasse" name="motDePasse" class="mt-1 block w-full border-gray-300 rounded-md shadow-sm p-2 focus:ring-indigo-500 focus:border-indigo-500" required>
        </div>
        <button type="submit" class="w-full bg-indigo-600 text-white p-2 rounded-md hover:bg-indigo-700">Se connecter</button>
    </form>
    <form action="utilisateurs" method="get" class="mt-4 text-center">
        <input type="hidden" name="action" value="logout">
<%--        <button type="submit" class="text-indigo-600 hover:underline">Déconnexion</button>--%>
    </form>
</div>
</body>
</html>