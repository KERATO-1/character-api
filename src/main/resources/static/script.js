async function loadCharacters() {
  const container = document.getElementById("characters");

  try {
    const response = await fetch("/characters");

    if (!response.ok) {
      throw new Error("Failed to fetch characters");
    }

    const data = await response.json();

    container.innerHTML = "";

    data.forEach(character => {
      const div = document.createElement("div");

      div.innerHTML = `
        <h2>${character.name}</h2>
        <img src="/naruto.jpg" width="150">
        <p>${character.description}</p>
        <p><strong>Universe:</strong> ${character.universe}</p>
        <p><strong>Species:</strong> ${character.species}</p>
        <p><strong>ID:</strong> ${character.characterId}</p>

        <a href="details.html?id=${character.characterId}">View Details</a>
        <a href="update.html?id=${character.characterId}">Edit</a>
        <button onclick="deleteCharacter(${character.characterId})">Delete</button>
        <hr>
      `;

      container.appendChild(div);
    });

  } catch (error) {
    console.error(error);
    container.innerHTML = "<p>Error loading characters</p>";
  }
}

async function deleteCharacter(id) {
  const confirmed = confirm("Are you sure you want to delete this character?");
  if (!confirmed) return;

  try {
    const response = await fetch(`/characters/${id}`, {
      method: "DELETE"
    });

    if (!response.ok) {
      throw new Error("Delete failed");
    }

    loadCharacters();
  } catch (error) {
    console.error(error);
    alert("Could not delete character");
  }
}

loadCharacters();