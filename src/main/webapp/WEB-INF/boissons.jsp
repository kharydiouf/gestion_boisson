
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Boissons</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
<div class="container mx-auto p-6">
    <nav class="mb-6">
        <ul class="flex space-x-4">
            <li><a href="boissons" class="text-indigo-600 hover:underline">Boissons</a></li>
            <li><a href="categories" class="text-indigo-600 hover:underline">Catégories</a></li>
            <li><a href="utilisateurs?logout" class="text-red-600 hover:underline">Déconnexion</a></li>
        </ul>
    </nav>
    <h1 class="text-3xl font-bold mb-6 text-center">Gestion des Boissons</h1>
    <div class="bg-white p-6 rounded-lg shadow-md mb-6">
        <h2 class="text-xl font-semibold mb-4">Ajouter une boisson</h2>
        <form action="boissons" method="post" class="space-y-4">
            <div>
                <label for="nom" class="block text-sm font-medium text-gray-700">Nom</label>
                <input type="text" id="nom" name="nom" class="mt-1 block w-full border-gray-300 rounded-md shadow-sm p-2 focus:ring-indigo-500 focus:border-indigo-500" required>
            </div>
            <div>
                <label for="prix" class="block text-sm font-medium text-gray-700">Prix</label>
                <input type="number" id="prix" step="0.01" name="prix" class="mt-1 block w-full border-gray-300 rounded-md shadow-sm p-2 focus:ring-indigo-500 focus:border-indigo-500" required>
            </div>
            <button type="submit" class="bg-indigo-600 text-white px-4 py-2 rounded-md hover:bg-indigo-700">Ajouter</button>
        </form>
    </div>
    <div class="bg-white p-6 rounded-lg shadow-md">
        <h2 class="text-xl font-semibold mb-4">Liste des boissons</h2>
        <table class="w-full border-collapse">
            <thead>
            <tr class="bg-gray-200">
<%--                <th class="p-2">ID</th>--%>
                <th class="p-2">Nom</th>
                <th class="p-2">Prix</th>
                <th class="p-2">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="boisson" items="${boissons}">
                <tr>
<%--                    <td class="p-2 border">${boisson.id}</td>--%>
                    <td class="p-2 border">${boisson.nom}</td>
                    <td class="p-2 border">${boisson.prix}</td>
                    <td class="p-2 border">
                        <!-- Bouton Modifier -->
                        <a href="edit-boisson?id=${boisson.id}"
                           class="bg-blue-500 text-white px-2 py-1 rounded-md hover:bg-blue-600">
                            Modifier
                        </a>

                        <!-- Bouton Supprimer -->
                        <form action="boissons" method="get" class="inline ml-2">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="${boisson.id}">
                            <button type="submit"
                                    class="bg-red-500 text-white px-2 py-1 rounded-md hover:bg-red-600"
                                    onclick="return confirm('Confirmer la suppression ?');">
                                Supprimer
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>