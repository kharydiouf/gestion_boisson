<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Modifier une catégorie</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">

<div class="container mx-auto p-6">
    <h1 class="text-3xl font-bold mb-6 text-center">Modifier la Catégorie</h1>

    <div class="bg-white p-6 rounded-lg shadow-md">
        <form action="edit-categorie" method="post" class="space-y-4">
            <!-- Champ caché pour l'ID -->
            <input type="hidden" name="id" value="${categorie.id}">

            <!-- Nom -->
            <div>
                <label for="nom" class="block text-sm font-medium text-gray-700">Nom de la catégorie</label>
                <input type="text" id="nom" name="nom" value="${categorie.nom}"
                       class="mt-1 block w-full border-gray-300 rounded-md shadow-sm p-2 focus:ring-indigo-500 focus:border-indigo-500"
                       required>
            </div>

            <!-- Boutons -->
            <div class="flex space-x-2">
                <button type="submit"
                        class="bg-blue-600 text-white px-4 py-2 rounded-md hover:bg-blue-700">
                    ✅ Mettre à jour
                </button>
                <a href="categories"
                   class="bg-gray-500 text-white px-4 py-2 rounded-md hover:bg-gray-600">
                    🔙 Annuler
                </a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
