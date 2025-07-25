
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Catégories</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
<div class="container mx-auto p-6">
    <!-- Navigation -->
    <nav class="mb-6">
        <ul class="flex space-x-4">
            <li><a href="boissons" class="text-indigo-600 hover:underline">Boissons</a></li>
            <li><a href="categories" class="text-indigo-600 hover:underline font-bold">Catégories</a></li>
            <li><a href="utilisateurs?logout" class="text-red-600 hover:underline">Déconnexion</a></li>
        </ul>
    </nav>

    <!-- Titre -->
    <h1 class="text-3xl font-bold mb-6 text-center">Gestion des Catégories</h1>

    <!-- Formulaire d'ajout -->
    <div class="bg-white p-6 rounded-lg shadow-md mb-6">
        <h2 class="text-xl font-semibold mb-4">Ajouter une catégorie</h2>
        <form action="categories" method="post" class="space-y-4">
            <div>
                <label for="nom" class="block text-sm font-medium text-gray-700">Nom</label>
                <input type="text" id="nom" name="nom"
                       class="mt-1 block w-full border-gray-300 rounded-md shadow-sm p-2 focus:ring-indigo-500 focus:border-indigo-500"
                       required>
            </div>
            <button type="submit"
                    class="bg-indigo-600 text-white px-4 py-2 rounded-md hover:bg-indigo-700">
                Ajouter
            </button>
        </form>
    </div>

    <!-- Liste des catégories -->
    <div class="bg-white p-6 rounded-lg shadow-md">
        <h2 class="text-xl font-semibold mb-4">Liste des catégories</h2>
        <table class="w-full border-collapse">
            <thead>
            <tr class="bg-gray-200">
                <th class="p-2">ID</th>
                <th class="p-2">Nom</th>
                <th class="p-2">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="categorie" items="${categories}">
                <tr>
                    <td class="p-2 border">${categorie.id}</td>

                    <!-- Nom modifiable -->
                    <td class="p-2 border">
                        <form action="categories" method="post" class="inline">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="id" value="${categorie.id}">
                            <input type="text" name="nom" value="${categorie.nom}"
                                   class="border p-1 rounded w-32">
                        </form>
                    </td>

                    <!-- Actions -->
                    <td class="p-2 border">
                        <!-- Bouton Modifier -->
                        <form action="categories" method="post" class="inline">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="id" value="${categorie.id}">
                            <input type="hidden" name="nom" value="${categorie.nom}">
                            <button type="submit"
                                    class="bg-yellow-500 text-white px-2 py-1 rounded-md hover:bg-yellow-600">
                                Mettre à jour
                            </button>
                        </form>

                        <!-- Bouton Supprimer -->
                        <form action="categories" method="get" class="inline ml-2">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="${categorie.id}">
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
