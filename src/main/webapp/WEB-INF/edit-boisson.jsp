<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Modifier une Boisson</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
<div class="container mx-auto p-6">
    <h1 class="text-2xl font-bold mb-4">Modifier la Boisson</h1>

    <form action="boissons" method="post" class="space-y-4">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${boisson.id}">

        <div>
            <label for="nom" class="block">Nom</label>
            <input type="text" id="nom" name="nom" value="${boisson.nom}"
                   class="mt-1 block w-full border-gray-300 rounded-md shadow-sm p-2">
        </div>

        <div>
            <label for="prix" class="block">Prix</label>
            <input type="number" step="0.01" id="prix" name="prix" value="${boisson.prix}"
                   class="mt-1 block w-full border-gray-300 rounded-md shadow-sm p-2">
        </div>

        <button type="submit" class="bg-indigo-600 text-white px-4 py-2 rounded-md hover:bg-indigo-700">
            Mettre à jour
        </button>
    </form>

    <a href="boissons" class="text-blue-600 hover:underline mt-4 inline-block">⬅ Retour</a>
</div>
</body>
</html>
