function getId() {
  const params = new URLSearchParams(window.location.search);
  return params.get("id");
}

async function loadCharacter() {
  const id = getId();

  try {
    const response = await fetch(`/characters/${id}`);

    if (!response.ok) {
      throw new Error("Failed to load character");
    }

    const character = await response.json();

    document.getElementById("name").value = character.name;
    document.getElementById("description").value = character.description;
    document.getElementById("universe").value = character.universe;
    document.getElementById("species").value = character.species;
  } catch (error) {
    console.error(error);
    alert("Failed to load character");
  }
}

document.getElementById("update-form").addEventListener("submit", async function(event) {
  event.preventDefault();

  const id = getId();

  const updatedCharacter = {
    name: document.getElementById("name").value,
    description: document.getElementById("description").value,
    universe: document.getElementById("universe").value,
    species: document.getElementById("species").value
  };

  try {
    const response = await fetch(`/characters/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(updatedCharacter)
    });

    if (!response.ok) {
      throw new Error("Update failed");
    }

    window.location.href = `details.html?id=${id}`;
  } catch (error) {
    console.error(error);
    alert("Error updating character");
  }
});

loadCharacter();